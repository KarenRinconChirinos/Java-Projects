package com.nikki.almacenverduleria;

public class NoPerecible extends Producto{
    private int contenido;
    private int calorias;

    public NoPerecible(int contenido, int calorias) {
        this.contenido = contenido;
        this.calorias = calorias;
    }

    public NoPerecible(String nombre, Double precio, int contenido, int calorias) {
        super(nombre, precio);
        this.calorias = calorias;
        this.contenido = contenido;
    }

    public int getContenido() {
        return contenido;
    }

    public void setContenido(int contenido) {
        this.contenido = contenido;
    }

    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }
}
