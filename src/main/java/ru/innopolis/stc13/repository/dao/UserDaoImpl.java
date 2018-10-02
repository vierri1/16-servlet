package ru.innopolis.stc13.repository.dao;

import ru.innopolis.stc13.pojo.Mobile;
import ru.innopolis.stc13.pojo.User;
import ru.innopolis.stc13.repository.connectionManager.ConnectionManager;
import ru.innopolis.stc13.repository.connectionManager.ConnectionManagerJdbcImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    ConnectionManager connectionManager;

    public UserDaoImpl() {
        connectionManager = ConnectionManagerJdbcImpl.getInstance();
    }

    @Override
    public User getUserByLogin(String login) throws SQLException {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM \"user\" WHERE name=?")) {

            preparedStatement.setString(1, login);
            User user = new User();
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    user.setId(resultSet.getInt("id"));
                    user.setHashPassword(resultSet.getString("password"));
                    user.setName(resultSet.getString("name"));
                    user.setRole(resultSet.getInt("role"));
                }
                return user;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
