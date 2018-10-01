package ru.innopolis.stc13.repository.dao;

import ru.innopolis.stc13.pojo.Mobile;
import ru.innopolis.stc13.repository.connectionManager.ConnectionManager;
import ru.innopolis.stc13.repository.connectionManager.ConnectionManagerJdbcImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MobileDaoJdbcImpl implements MobileDao {
    private static ConnectionManager connectionManager =
            ConnectionManagerJdbcImpl.getInstance();

    @Override
    public boolean addMobile(Mobile mobile) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO mobile values (DEFAULT, ?, ?, ?)");) {

            preparedStatement.setString(1, mobile.getModel());
            preparedStatement.setFloat(2, mobile.getPrice());
            preparedStatement.setInt(3, mobile.getManufacturer());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Mobile getMobileById(Integer id) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM mobile WHERE id = ?");) {

            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                if (resultSet.next()) {
                    return new Mobile(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getFloat(3),
                            resultSet.getInt(4));

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Mobile> getMobileList(Integer brandId) {
        List<Mobile> result = null;
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM mobile WHERE manufacturer_id = ?");) {
            preparedStatement.setInt(1, brandId);
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                result = new ArrayList<>();
                while (resultSet.next()) {
                    result.add(new Mobile(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getFloat(3),
                            resultSet.getInt(4)));

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean updateMobileById(Mobile mobile) {

        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE mobile SET model=?, price=?, manufacturer_id=? " +
                             "WHERE id=?");) {

            preparedStatement.setString(1, mobile.getModel());
            preparedStatement.setFloat(2, mobile.getPrice());
            preparedStatement.setInt(3, mobile.getManufacturer());
            preparedStatement.setInt(4, mobile.getId());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteMobileById(Integer id) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "DELETE FROM mobile WHERE id=?");) {

            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
