package com.nikki.patrones.decorador2;

public class Cafe implements Configurable{
    private float precio;
    private  String nombre;

    public Cafe(float precio, String nombre) {
        this.precio = precio;
        this.nombre = nombre;
    }

    @Override
    public float getPrecioBase() {
        return this.precio;
    }

    @Override
    public String getIngrediente() {
        return this.nombre;
    }
}
