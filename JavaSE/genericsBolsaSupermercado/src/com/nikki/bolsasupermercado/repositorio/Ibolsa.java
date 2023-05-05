package com.nikki.bolsasupermercado.repositorio;

import java.util.List;

public interface Ibolsa <T>{
    <T> void addProducto(T t);
    List<T> obtenerProducto();
}
