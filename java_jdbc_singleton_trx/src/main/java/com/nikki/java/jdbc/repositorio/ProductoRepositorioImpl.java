package com.nikki.java.jdbc.repositorio;

import com.nikki.java.jdbc.modelo.Categoria;
import com.nikki.java.jdbc.modelo.Producto;
import com.nikki.java.jdbc.util.ConexionBaseDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepositorioImpl implements Repositorio<Producto> {

    private Connection getConnection() throws SQLException {
        return ConexionBaseDatos.getConnection();
    }

    @Override
    public List<Producto> listar() throws SQLException {
        List<Producto> productos = new ArrayList<>();
        try(Statement stmt = getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT p.* , c.nombre as categoria " +
                    "FROM productos as p  INNER JOIN categorias as c " +
                    "ON (p.categoriaId = c.id)")){
            while(rs.next()){
               Producto p = crearProducto(rs);
               productos.add(p);
            }
        }
        return productos;
    }
    @Override
    public Producto porId(Long id) throws SQLException {
        Producto producto = null;
        try(PreparedStatement pstmt = getConnection()
                .prepareStatement("SELECT p.* , c.nombre as categoria " +
                        " FROM productos as p  INNER JOIN categorias as c " +
                        "  ON (p.categoriaId = c.id) WHERE p.id = ?")){
            pstmt.setLong(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    producto = crearProducto(rs);
                }
            }
        }
        return producto;
    }

    @Override
    public void guardar(Producto producto) throws SQLException {
        String sql;
        if (producto.getId() != null && producto.getId() > 0) { //actualizacion
            sql = " UPDATE productos SET nombre =?, precio = ?, categoriaId = ?, sku = ?  WHERE id = ?";
        } else {
            sql = " INSERT INTO productos(nombre, precio, categoriaId, sku, fechaRegistro) VALUES (?,?,?,?,?)";
        }
        try (PreparedStatement pstmt = getConnection().prepareStatement(sql)) {
            pstmt.setString(1, producto.getNomnbre());
            pstmt.setInt(2, producto.getPrecio());
            pstmt.setLong(3, producto.getCategoria().getId());
            pstmt.setString(4, producto.getSku());
            if (producto.getId() != null && producto.getId() > 0) { //actualizacion
                pstmt.setLong(5, producto.getId());
            } else {
                pstmt.setDate(5, new Date(producto.getFechaRegistro().getTime()));
            }
            pstmt.executeUpdate();
        }
    }

    @Override
    public void eliminar(Long id) throws SQLException {
        try(PreparedStatement pstmt = getConnection().prepareStatement("DELETE FROM productos WHERE id = ?")) {
            pstmt.setLong(1, id);
            pstmt.executeUpdate();
        }
    }



    private Producto crearProducto(ResultSet rs) throws SQLException {
        Producto p = new Producto();
        p.setId(rs.getLong("id"));
        p.setNomnbre(rs.getString("nombre"));
        p.setPrecio(rs.getInt("precio"));
        p.setFechaRegistro(rs.getDate("fechaRegistro"));
        p.setSku(rs.getString("sku"));
        Categoria categoria = new Categoria();
        categoria.setId(rs.getLong("categoriaId"));
        categoria.setNombre(rs.getString("categoria"));
        p.setCategoria(categoria);
        return p;
    }

}