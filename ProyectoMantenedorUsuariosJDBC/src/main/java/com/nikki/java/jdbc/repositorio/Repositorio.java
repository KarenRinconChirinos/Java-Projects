package com.nikki.java.jdbc.repositorio;

public interface Repositorio <T>{
    void crear (T t);
    void listar ();
    void actualizar();
    void eliminar(int id);

}
