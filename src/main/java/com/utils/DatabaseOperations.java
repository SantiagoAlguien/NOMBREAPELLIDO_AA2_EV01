package com.utils;

import com.utils.models.Prueba;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseOperations {

    public Connection getConnection() throws SQLException {
        return DatabaseConnection.getConnection();
    }

    public void insertPrueba(Connection connection, Prueba prueba) throws SQLException {
        String sql = "INSERT INTO prueba (id, username, password) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, prueba.getId());
            statement.setString(2, prueba.getName());
            statement.setString(3, prueba.getPassword());
            statement.executeUpdate();
        }
    }

    public List<Prueba> getPruebas(Connection connection) throws SQLException {
        String sql = "SELECT * FROM prueba";
        List<Prueba> pruebas = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                Prueba prueba = new Prueba(
                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("password")
                );
                pruebas.add(prueba);
            }
        }
        return pruebas;
    }

    public void updatePrueba(Connection connection, Prueba prueba) throws SQLException {
        String sql = "UPDATE prueba SET username = ?, password = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, prueba.getName());
            statement.setString(2, prueba.getPassword());
            statement.setInt(3, prueba.getId());
            statement.executeUpdate();
        }
    }

    public void deletePrueba(Connection connection, int id) throws SQLException {
        String sql = "DELETE FROM prueba WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}
