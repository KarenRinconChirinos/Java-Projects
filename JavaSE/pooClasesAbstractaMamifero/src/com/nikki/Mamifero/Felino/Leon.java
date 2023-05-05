package com.nikki.Mamifero.Felino;

public class Leon extends Felino {
    private int numeroManada;
    private double potenciaRugido; //en decibel

    public Leon(String habitad, Float altura, Float largo, double peso, String nombreCientifico, double tamañoGarras, int velocidad, int numeroManada, double potenciaRugido) {
        super(habitad, altura, largo, peso, nombreCientifico, tamañoGarras, velocidad);
        this.numeroManada = numeroManada;
        this.potenciaRugido = potenciaRugido;
    }

    public int getNumeroManada() {
        return numeroManada;
    }

    public double getPotenciaRugido() {
        return potenciaRugido;
    }

    @Override
    public String comer() {
        return "El Leon por su tamaño " + this.getTamañoGarras() + " de garras puede cazar junto a su grupo de " + this.numeroManada + " individuos en " + this.getHabitad();
    }

    @Override
    public String dormir() {
        return "El Leon duerme junto a su grupo de " + this.numeroManada + " en " + this.getHabitad();
    }

    @Override
    public String correr() {
        return "El Leon con un peso de " + this.getPeso() +", " + this.getAltura() + " de altura, " + this.getLargo() + " de largo y una velocidad de " + this.getVelocidad() + " km/h, lo le permite conocer todo los sitios de " + this.getHabitad() + " junto a su grupo de " + this.numeroManada + " individuos";
    }

    @Override
    public String comunicarse() {
        return "El Leon  con su potencia de rugido de " + this.potenciaRugido + "permite comunicarse con sus su grupo, por lo que lo hace un animal muy especial";
    }
}
