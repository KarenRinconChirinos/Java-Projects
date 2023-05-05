package com.nikki.AlmacenVentas;

import java.util.Date;

public class Perecederos extends Alimento{
    private double peso;
    private String color;

    public Perecederos(String lugar) {
        super(lugar);
    }

    public Perecederos(String lugar, String nombre, int cantidad, String descripcion, double precio, Date fechaCaducidad, double peso, String color) {
        super(lugar, nombre, cantidad, descripcion, precio, fechaCaducidad);
        this.peso = peso;
        this.color = color;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
