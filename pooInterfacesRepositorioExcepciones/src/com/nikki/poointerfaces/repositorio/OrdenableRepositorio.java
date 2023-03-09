package com.nikki.poointerfaces.repositorio;

import com.nikki.poointerfaces.modelo.Cliente;

import java.util.List;

public interface OrdenableRepositorio <T> {
    List<T> listar(String campo, Direccion dir);
}
