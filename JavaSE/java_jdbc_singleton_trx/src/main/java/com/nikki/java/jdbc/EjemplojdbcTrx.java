package com.nikki.java.jdbc;

import com.nikki.java.jdbc.modelo.Categoria;
import com.nikki.java.jdbc.modelo.Producto;
import com.nikki.java.jdbc.repositorio.ProductoRepositorioImpl;
import com.nikki.java.jdbc.repositorio.Repositorio;
import com.nikki.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class EjemplojdbcTrx {
    public static void main(String[] args) throws SQLException {

        try (Connection connection = ConexionBaseDatos.getConnection();) {
            if (connection.getAutoCommit()) {
                connection.setAutoCommit(false);
            }
            try {
                Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
                System.out.println("\n------------  Listar productos  ------------ ");
                System.out.println(repositorio.listar().get(1).getId());
                System.out.println("\n------------  Buscar por id  ------------ ");
                System.out.println(repositorio.porId(2l));
                System.out.println("\n------------  Guardar productos  ------------ ");
                Producto p = new Producto();
                p.setNomnbre("Teclado Colorfull match");
                p.setPrecio(850);
                p.setFechaRegistro(new Date());
                Categoria cat = new Categoria();
                cat.setId(3l);
                p.setCategoria(cat);
                p.setSku("abc07");
                repositorio.guardar(p);
                repositorio.listar().forEach(System.out::println);

                System.out.println("\n------------  Actualizar productos  ------------ ");
                p = new Producto();
                p.setId(15l);
                p.setNomnbre("Mouse Rizen Luces Led");
                p.setPrecio(750);
                p.setSku("abc08");
                cat = new Categoria();
                cat.setId(2l);
                p.setCategoria(cat);
                repositorio.guardar(p);
                repositorio.listar().forEach(System.out::println);

                connection.commit();
                /*
                 * si falla alguna operacion, ya sea actaulizar, guardar, listar, etc realiza un rollback y se regresa al estado anterior            *
                 * */
            } catch (SQLException e) {
                connection.rollback(); // si falla un rollback un retroceso
                e.printStackTrace();
            }
        }
    }
}
