package com.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://roundhouse.proxy.rlwy.net:53494/railway";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "QXcPDOMeKHEBWbsPEJzkfDeYcWbGPfgU";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
