package com.nikki.java.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {
    private static String url = "jdbc:mysql://localhost:3306/javacurso?serverTimezone=UTC"; // puede cambiar dependeiendo el tipo de bd
    private static String username =  "root";
    private static String password = "fettuchini";
    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}
