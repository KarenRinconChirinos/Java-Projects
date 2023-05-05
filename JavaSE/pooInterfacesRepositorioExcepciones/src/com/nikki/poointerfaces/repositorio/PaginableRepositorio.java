package com.nikki.poointerfaces.repositorio;

import com.nikki.poointerfaces.modelo.Cliente;

import java.util.List;

public interface PaginableRepositorio<T>{
    List<T> listar(int desde, int hasta);
}
