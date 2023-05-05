package com.nikki.java.jdbc.servicio;

import com.nikki.java.jdbc.modelo.Categoria;
import com.nikki.java.jdbc.modelo.Producto;

import java.sql.SQLException;
import java.util.List;

public interface Servicio {
    // para producto y categoria
    List<Producto> listar() throws SQLException;
    Producto porId(Long id) throws SQLException;
    Producto guardar (Producto producto) throws SQLException;
    void eliminar(Long id) throws SQLException;

    List<Categoria> listarCategoria() throws SQLException;
    Categoria porIdCategoria(Long id) throws SQLException;
    Categoria guardarCategoria(Categoria categoria) throws SQLException;
    void eliminarCategoria(Long id) throws SQLException;
    void guardarProductoConCategoria(Producto producto, Categoria categoria) throws SQLException;
}
