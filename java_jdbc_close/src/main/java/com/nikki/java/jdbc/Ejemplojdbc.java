package com.nikki.java.jdbc;

import com.nikki.java.jdbc.modelo.Categoria;
import com.nikki.java.jdbc.modelo.Producto;
import com.nikki.java.jdbc.repositorio.ProductoRepositorioImpl;
import com.nikki.java.jdbc.repositorio.Repositorio;
import com.nikki.java.jdbc.util.ConexionBaseDatos;

import java.sql.*;
import java.util.Date;

public class Ejemplojdbc {
    public static void main(String[] args) {

        try (Connection connection = ConexionBaseDatos.getConnection();){
            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            System.out.println("\n------------  Listar productos  ------------ ");
            repositorio.listar().forEach(System.out::println);
            System.out.println("\n------------  Buscar por id  ------------ ");
            System.out.println(repositorio.porId(2l));
            System.out.println("\n------------  Guardar productos  ------------ ");
            Producto p = new Producto();
            p.setNomnbre("Mouse");
            p.setPrecio(150);
            p.setFechaRegistro(new Date());
            Categoria cat = new Categoria();
            cat.setId(3l);
            p.setCategoria(cat);
            repositorio.guardar(p);
            repositorio.listar().forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
