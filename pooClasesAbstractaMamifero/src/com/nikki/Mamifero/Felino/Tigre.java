package com.nikki.Mamifero.Felino;

public class Tigre extends Felino {
    private String especie;

    public Tigre(String habitad, Float altura, Float largo, Double peso, String nombreCientifico, Double tamañoGarras, int velocidad, String especie) {
        super(habitad, altura, largo, peso, nombreCientifico, tamañoGarras, velocidad);
        this.especie = especie;
    }

    public String getEspecie() {
        return especie;
    }

    @Override
    public String comer() {
        return "El Tigre por su peso de " + this.getPeso() + " y velocidad de " + this.getVelocidad() + " puede llegar a cazar  en " + this.getHabitad();
    }

    @Override
    public String dormir() {
        return "El Tigre por su ser un " + this.especie + " suelen dormir en en conjunto";
    }

    @Override
    public String correr() {
        return "El Tigre por su  velocidad de " + this.getVelocidad() + " puede llegar muy lejos!!";
    }

    @Override
    public String comunicarse() {
        return "El Tigre puede ser comunicativo";
    }
}
