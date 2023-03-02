package com.nikki.Mamifero.Felino;

public class Guepardo extends Felino{
    public Guepardo(String habitad, Float altura, Float largo, Double peso, String nombreCientifico, Double tamañoGarras, int velocidad) {
        super(habitad, altura, largo, peso, nombreCientifico, tamañoGarras, velocidad);
    }

    @Override
    public String comer() {
        return "El Guepardo por su  peso de " + this.getPeso() + " y velocidad de " + this.getVelocidad() + " puede llegar a cazar  en " + this.getHabitad();
    }

    @Override
    public String dormir() {
        return "El Guepardo duerme junto a su grupo en " + this.getHabitad();
    }

    @Override
    public String correr() {
        return "El Guepardo por su  velocidad de " + this.getVelocidad() + " puede llegar muy lejos!!";
    }

    @Override
    public String comunicarse() {
        return "El Guepardo puede ser comunicativo";
    }
}
