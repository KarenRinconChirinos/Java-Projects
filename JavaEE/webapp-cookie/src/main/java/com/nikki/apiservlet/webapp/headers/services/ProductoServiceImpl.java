package com.nikki.apiservlet.webapp.headers.services;

import com.nikki.apiservlet.webapp.headers.models.Producto;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ProductoServiceImpl implements ProductoService{

    @Override
    public List<Producto> listar() {
        return Arrays.asList(new Producto(1L, "Lapiz tactil Apple", "Computacion", 5750),
                new Producto(2L, "Laptp Mac Air Pro", "Computacion", 25000),
                new Producto(3L, "Mochila laptop", "Computacion", 500));
    }

    @Override
    public Optional<Producto> buscarProducto(String nombre) {
        ProductoService service = new ProductoServiceImpl();
        Optional<Producto> encontrado = service.listar().stream().filter(
                        p -> {
                            if(nombre == null || nombre.isBlank()){
                                return false;
                            }
                            return p.getNombre().contains(nombre);
                        })
                .findFirst();
        return encontrado;
    }


}
