package com.nikki.optional.ejemplo.repositorio;

import com.nikki.optional.ejemplo.models.Computador;

import java.util.Optional;

public interface IRepositorio<T> {
    Optional<Computador> filtrar (String nombre);
}
