package com.nikki.java.jdbc;

import com.nikki.java.jdbc.modelo.Categoria;
import com.nikki.java.jdbc.modelo.Producto;
import com.nikki.java.jdbc.repositorio.ProductoRepositorioImpl;
import com.nikki.java.jdbc.repositorio.Repositorio;
import com.nikki.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class EjemplojdbcUpdate {
    public static void main(String[] args) {

        try (Connection connection = ConexionBaseDatos.getConnection();){
            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            System.out.println("\n------------  Listar productos  ------------ ");
            repositorio.listar().forEach(System.out::println);
            System.out.println("\n------------  Buscar por id  ------------ ");
            System.out.println(repositorio.porId(2l));

            System.out.println("\n------------  Actualizar productos  ------------ ");
            Producto p = new Producto();
            p.setId(6l);
            p.setNomnbre("Mouse Rizen Luces Led");
            p.setPrecio(550);
            Categoria cat = new Categoria();
            cat.setId(2l);
            p.setCategoria(cat);
            repositorio.guardar(p);
            repositorio.listar().forEach(System.out::println);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
