package com.nikki.proyectocatalogo.productos;

public interface IProducto {
    default int getPrecio() {
        return 0;
    }

    double getPrecioVenta();
}
