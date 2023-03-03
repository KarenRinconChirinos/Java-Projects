package com.nikki.AlmacenVentas;

public class Carrito {
    private Productos productos;
    private Persona persona;
    private int cantidad;

    public Carrito(Productos productos, Persona persona, int cantidad) {
        this.productos = productos;
        this.persona = persona;
        this.cantidad = cantidad;
    }


    public Carrito(Persona persona) {
        this.persona = persona;
    }

    public void addProductos(Productos productos) {
        this.productos = productos;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
