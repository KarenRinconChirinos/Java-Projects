package com.nikki.AlmacenVentas;

public class Area extends Ventas{
    private String nombre;

    public Area(String nombre, int edad, String rfc, String area, double sueldo) {
        super(nombre, edad, rfc, area, sueldo);
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
