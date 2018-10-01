package ru.innopolis.stc13.repository.dao;

import ru.innopolis.stc13.pojo.Brand;
import ru.innopolis.stc13.repository.connectionManager.ConnectionManager;
import ru.innopolis.stc13.repository.connectionManager.ConnectionManagerJdbcImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BrandDaoImpl implements BrandDao {
    private static ConnectionManager connectionManager =
            ConnectionManagerJdbcImpl.getInstance();

    @Override
    public List<Brand> getBrandList() {
        List<Brand> result = null;
        try (Connection connection = connectionManager.getConnection();
             Statement statement = connection.createStatement();) {

            try (ResultSet resultSet = statement.executeQuery("SELECT * FROM manufacturer");) {
                result = new ArrayList<>();
                while (resultSet.next()) {
                    result.add(new Brand(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3)));

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
