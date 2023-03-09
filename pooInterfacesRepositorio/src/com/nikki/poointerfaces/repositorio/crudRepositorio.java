package com.nikki.poointerfaces.repositorio;

import com.nikki.poointerfaces.modelo.Cliente;

import java.util.List;

public interface crudRepositorio <T> {
    List<T> listar(); // fuente
    T buscarId(Integer id); //obtener cliente por Id
    void crear(T object);
    void actualizar(T o);
    void eliminar(Integer id);
}
