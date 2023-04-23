package com.nikki.java.jdbc.repositorio;

import com.nikki.java.jdbc.modelo.Usuario;
import com.nikki.java.jdbc.util.ConexionBaseDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepositorioImpl implements Repositorio<Usuario>{

    private Connection getInstance() throws SQLException {
        return ConexionBaseDatos.getConnection();
    }

    @Override
    public void crear(Usuario usuario) {
        String sql;
        if (usuario.getId()>0){ //actualizacion de nuevo usuario
            sql = " UPDATE usuarios SET username = ?, password = ?, email = ?  WHERE id = ?";
        } else { // insertar nuevo usuario
            sql = " INSERT INTO usuarios(username, password, email) VALUES (?,?,?)";
        }
        try(PreparedStatement pstmt = getInstance().prepareStatement(sql)) {
            pstmt.setString(1, usuario.getUsername());
            pstmt.setString(2, usuario.getEmail());
            pstmt.setString(3, usuario.getPassword());
            if ( usuario.getId()>0) { //actualizacion
                pstmt.setInt(4, usuario.getId());
            }
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Usuario> listar() {
        List<Usuario> usuarios = new ArrayList<>();
        try(Connection connection = getInstance();
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM usuarios")) {
            while(resultSet.next()){
                Usuario u = new Usuario();
                u.setId(resultSet.getInt("id"));
                u.setEmail(resultSet.getString("email"));
                u.setUsername(resultSet.getString("username"));
                u.setPassword(resultSet.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    public List<Usuario> listarid() {
        List<Usuario> usuarios = new ArrayList<>();
        try(Connection connection = getInstance();
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT id FROM usuarios")) {
            while(resultSet.next()){
                Usuario u = new Usuario();
                u.setId(resultSet.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    @Override
    public void eliminar(int id) {
        try(PreparedStatement pstmt = getInstance().prepareStatement("DELETE FROM usuarios WHERE id = ?")) {
            pstmt.setLong(1,id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Usuario porId(int id) {
        Usuario u = new Usuario();
        try(PreparedStatement pstmt = getInstance()
                .prepareStatement("SELECT user.* " +
                        " FROM usuarios as user  WHERE user.id = ?")){
            pstmt.setLong(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    u.setId(rs.getInt("id"));
                    u.setEmail(rs.getString("email"));
                    u.setUsername(rs.getString("username"));
                    u.setPassword(rs.getString("password"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }
}
