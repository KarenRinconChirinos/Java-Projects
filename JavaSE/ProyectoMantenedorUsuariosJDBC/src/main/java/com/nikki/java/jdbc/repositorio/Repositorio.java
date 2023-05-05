package com.nikki.java.jdbc.repositorio;

import java.util.List;

public interface Repositorio <T>{
    void crear (T t);
    List<T> listar ();
    void eliminar(int id);
    T porId(int id);
}
