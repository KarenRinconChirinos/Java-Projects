package com.nikki.java.jdbc.repositorio;

import com.nikki.java.jdbc.modelo.Categoria;
import com.nikki.java.jdbc.modelo.Producto;
import com.nikki.java.jdbc.util.ConexionBaseDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepositorioImpl implements Repositorio<Producto> {

    private Connection conn;

    public ProductoRepositorioImpl() {
    }

    public ProductoRepositorioImpl(Connection conn) {
        this.conn = conn;
    }


    public void setConn(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Producto> listar() throws SQLException {
        List<Producto> productos = new ArrayList<>();
        try(Statement stmt = conn.createStatement();
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
        try(PreparedStatement pstmt = conn
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
    public Producto guardar(Producto producto) throws SQLException {
        String sql =  null;
        if (producto.getId() != null && producto.getId()>0) { //actualizacion
            sql = "UPDATE productos SET nombre = ?, precio = ?, categoriaId = ?, sku = ? WHERE id = ?";
        } else {
            sql = "INSERT INTO productos(nombre, precio, categoriaId, sku, fechaRegistro) VALUES (?,?,?,?,?)";
        }
        try(PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, producto.getNomnbre());
            pstmt.setInt(2, producto.getPrecio());
            pstmt.setLong(3, producto.getCategoria().getId());
            pstmt.setString(4, producto.getSku());
            if (producto.getId() != null && producto.getId()>0) { //actualizacion
                pstmt.setLong(5, producto.getId());
            }else{
                pstmt.setDate(5,  new Date(producto.getFechaRegistro().getTime()));
            }
            pstmt.executeUpdate();
            if(producto.getId() == null){
                try( ResultSet rs = pstmt.getGeneratedKeys()){
                    if (rs.next()){
                        producto.setId(rs.getLong(1));
                    }
                }
            }
            return producto;
        }
    }

    @Override
    public void eliminar(Long id) throws SQLException {
        try(PreparedStatement pstmt = conn.prepareStatement("DELETE FROM productos WHERE id = ?")) {
            pstmt.setLong(1,id);
            pstmt.executeUpdate();
        }
    }



    private Producto crearProducto( ResultSet rs) throws SQLException {
        Producto p = new Producto();
        p.setId(rs.getLong("id"));
        p.setNomnbre(rs.getString("nombre"));
        p.setPrecio(rs.getInt("precio"));
        p.setSku(rs.getString("sku"));
        p.setFechaRegistro(rs.getDate("fechaRegistro"));
        Categoria categoria = new Categoria();
        categoria.setId(rs.getLong("categoriaId"));
        categoria.setNombre(rs.getString("categoria"));
        p.setCategoria(categoria);
        return p;
    }

}
