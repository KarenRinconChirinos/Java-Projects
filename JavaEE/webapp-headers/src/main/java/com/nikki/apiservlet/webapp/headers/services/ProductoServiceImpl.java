package com.nikki.apiservlet.webapp.headers.services;

import com.nikki.apiservlet.webapp.headers.models.Producto;

import java.util.Arrays;
import java.util.List;

public class ProductoServiceImpl implements ProductoService{

    @Override
    public List<Producto> listar() {
        return Arrays.asList(new Producto(1L, "Lapiz tactil Apple", "Computacion", 5750),
                new Producto(2L, "Laptp Mac Air Pro", "Computacion", 25000),
                new Producto(3L, "Mochila laptop", "Computacion", 500));
    }
}
