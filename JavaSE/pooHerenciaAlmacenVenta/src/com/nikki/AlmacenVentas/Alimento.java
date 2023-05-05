package com.nikki.AlmacenVentas;

import java.util.Date;
import java.util.zip.DataFormatException;

public class Alimento extends Productos {
    private Date fechaCaducidad;

    public Alimento(String lugar) {
        super(lugar);
    }

    public Alimento(String lugar, String nombre, int cantidad, String descripcion, double precio, Date fechaCaducidad) {
        super(lugar, nombre, cantidad, descripcion, precio);
        this.fechaCaducidad = fechaCaducidad;
    }

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }
}
