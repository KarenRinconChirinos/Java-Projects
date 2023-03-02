package com.nikki.Mamifero.Felino;

import com.nikki.Mamifero.Mamifero;

abstract public class Felino extends Mamifero {
    private double tamañoGarras;
    private int velocidad;


    public Felino(String habitad, Float altura,
                  Float largo, Double peso,
                  String nombreCientifico,
                  Double tamañoGarras, int velocidad) {
        super(habitad, altura, largo, peso, nombreCientifico);
        this.tamañoGarras = tamañoGarras;
        this.velocidad = velocidad;
    }

    public Double getTamañoGarras() {
        return tamañoGarras;
    }

    public int getVelocidad() {
        return velocidad;
    }
}
