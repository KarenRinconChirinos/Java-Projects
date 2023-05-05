package com.nikki.Mamifero.Canino;

import com.nikki.Mamifero.Mamifero;

abstract public class Canino extends Mamifero {
    private String color;
    private Double tamañoColmillos;

    public Canino(String habitad, Float altura,
                  Float largo, Double peso,
                  String nombreCientifico,
                  String color, Double tamañoColmillos) {
        super(habitad, altura, largo, peso, nombreCientifico);
        this.color = color;
        this.tamañoColmillos = tamañoColmillos;
    }

    public String getColor() {
        return color;
    }

    public Double getTamañoColmillos() {
        return tamañoColmillos;
    }
}
