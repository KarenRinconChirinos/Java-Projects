package com.nikki.java.jdbc;

import com.nikki.java.jdbc.modelo.Categoria;
import com.nikki.java.jdbc.modelo.Producto;
import com.nikki.java.jdbc.repositorio.CategoriaRepositorioImpl;
import com.nikki.java.jdbc.repositorio.ProductoRepositorioImpl;
import com.nikki.java.jdbc.repositorio.Repositorio;
import com.nikki.java.jdbc.servicio.CatalogoServicio;
import com.nikki.java.jdbc.servicio.Servicio;
import com.nikki.java.jdbc.util.ConexionBaseDatos;

import java.rmi.server.ServerCloneException;
import java.sql.*;
import java.util.Date;

public class Ejemplojdbc {
    public static void main(String[] args) throws SQLException {
            Servicio servicio = new CatalogoServicio();

            System.out.println("\n------------  Listar productos  ------------ ");
            servicio.listar().forEach(System.out::println);


            System.out.println("\n------------  Guardar categoria  ------------ ");
            Categoria cat = new Categoria();
            cat.setNombre("Iluminacion");
            servicio.guardarCategoria(cat);



            System.out.println("\n------------  Guardar productos  ------------ ");
            Producto p = new Producto();
            p.setNomnbre("Lampara escritorio fil dorado la p");
            p.setPrecio(1000);
            p.setSku("abc13");
            p.setFechaRegistro(new Date());
            servicio.guardarProductoConCategoria(p, cat);
            System.out.println("Producto guardado con exito " + p.getId());
            servicio.listar().forEach(System.out::println);

    }
}
