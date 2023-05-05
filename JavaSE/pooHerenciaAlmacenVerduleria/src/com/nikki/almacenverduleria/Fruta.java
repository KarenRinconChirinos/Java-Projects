package com.nikki.almacenverduleria;

public class Fruta extends  Producto{
    private double peso;
    private String color;

    public Fruta(double peso, String color) {
        this.peso = peso;
        this.color = color;
    }

    public Fruta(String nombre, double precio, double peso, String color){
        super(nombre, peso);
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
