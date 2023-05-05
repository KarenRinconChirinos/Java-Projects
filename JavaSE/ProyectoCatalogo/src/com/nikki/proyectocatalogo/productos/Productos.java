package com.nikki.proyectocatalogo.productos;

abstract public class Productos implements IProducto {
    private int precio;

    public Productos(int precio) {
        this.precio = precio;
    }

    @Override
    public int getPrecio() {
        return this.precio;
    }

    @Override
    public double getPrecioVenta() { //IVA
        return (precio * 0.17) + precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
