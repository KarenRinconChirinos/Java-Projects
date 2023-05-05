package com.nikki.Mamifero.Canino;

public class Lobo extends Canino {
    private int numeroCamada;
    private String especie;

    public Lobo(String habitad, Float altura, Float largo, Double peso, String nombreCientifico, String color, Double tamañoColmillos, int numeroCamada, String especie) {
        super(habitad, altura, largo, peso, nombreCientifico, color, tamañoColmillos);
        this.numeroCamada = numeroCamada;
        this.especie = especie;
    }

    public int getNumeroCamada() {
        return numeroCamada;
    }

    public String getEspecie() {
        return especie;
    }

    @Override
    public String comer() {
        return "El Lobo por su peso de " + this.getPeso() + " y velocidad de  puede llegar a cazar en " + this.getHabitad();
    }

    @Override
    public String dormir() {
        return "El Lobo por su  especie " + this.especie + " duerme en solitario" ;
    }

    @Override
    public String correr() {
        return "El Lobo por su peso de " + this.getPeso() + ", su altura de" + this.getAltura() + ", y largo de " + this.getLargo() +", son muy veloces";
    }

    @Override
    public String comunicarse() {
        return "El Lobo tiene un aullido capaz de invocar a toda su camada " + this.numeroCamada + " lobos ";
    }
}
