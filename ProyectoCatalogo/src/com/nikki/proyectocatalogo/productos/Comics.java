package com.nikki.proyectocatalogo.productos;

import java.util.Date;

public class Comics extends Libro {
    private String personaje;


    public Comics(int precio, Date fechaPublicacion, String autor, String titulo, String editorial, String personaje) {
        super(precio, fechaPublicacion, autor, titulo, editorial);
        this.personaje = personaje;
    }

    public String getPersonaje() {
        return personaje;
    }

    public void setPersonaje(String personaje) {
        this.personaje = personaje;
    }

    @Override
    public double getPrecioVenta() {
        return super.getPrecioVenta();
    }
}
