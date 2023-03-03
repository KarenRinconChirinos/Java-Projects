package com.nikki.AlmacenVentas;

import java.util.Date;

public class NoPerecederos extends  Alimento{
    private int contenido;
    private int calorias;

    public NoPerecederos(String lugar) {
        super(lugar);
    }

    public NoPerecederos(String lugar, String nombre, int cantidad, String descripcion, double precio, Date fechaCaducidad, int contenido, int calorias) {
        super(lugar, nombre, cantidad, descripcion, precio, fechaCaducidad);
        this.contenido = contenido;
        this.calorias = calorias;
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
