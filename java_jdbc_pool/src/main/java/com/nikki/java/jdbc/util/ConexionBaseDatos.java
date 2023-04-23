package com.nikki.java.jdbc.util;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {
    private static String url = "jdbc:mysql://localhost:3306/javacurso?serverTimezone=UTC"; // puede cambiar dependeiendo el tipo de bd
    private static String username =  "root";
    private static String password = "fettuchini";
    private static BasicDataSource pool;

    public static BasicDataSource getInstance() throws SQLException {
        if(pool == null){
            pool = new BasicDataSource();
            pool.setUrl(url);
            pool.setUsername(username);
            pool.setPassword(password);
            pool.setInitialSize(3);//inicializar con 3 abiertas
            pool.setMinIdle(3);//el minimo de conexiones que estan inactivas
            // que estan esperando para ser utilizadas
            pool.setMaxIdle(9); // maximo de conexiones incativas
            pool.setMaxTotal(9);//disponibles para ser utilizadas
        }
        return pool;
    }

    public static Connection getConnection() throws SQLException {
        return getInstance().getConnection();
    }
}
