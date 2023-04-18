package com.nikki.java.jdbc;

import com.nikki.java.jdbc.modelo.Producto;
import com.nikki.java.jdbc.repositorio.ProductoRepositorioImpl;
import com.nikki.java.jdbc.repositorio.Repositorio;
import com.nikki.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;

public class EjemplojdbcDelete {
    public static void main(String[] args) {

        try (Connection connection = ConexionBaseDatos.getConnection();){
            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            System.out.println("\n------------  Listar productos  ------------ ");
            repositorio.listar().forEach(System.out::println);
            System.out.println("\n------------  Buscar por id  ------------ ");
            System.out.println(repositorio.porId(2l));

            System.out.println("\n------------  Eliminar productos  ------------ ");
            Producto p = new Producto();
            p.setId(3l);
            repositorio.eliminar(p.getId());
            repositorio.listar().forEach(System.out::println);



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
