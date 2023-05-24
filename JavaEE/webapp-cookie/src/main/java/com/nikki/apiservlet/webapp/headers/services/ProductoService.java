package com.nikki.apiservlet.webapp.headers.services;

import com.nikki.apiservlet.webapp.headers.models.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    List<Producto> listar();
    Optional<Producto> buscarProducto (String nombre);
}
