package com.nikki.Mamifero.Canino;

public class Perro extends Canino {
    private int fuerzaMordida; // en psi

    public Perro(String habitad, Float altura, Float largo, Double peso, String nombreCientifico, String color, Double tamañoColmillos, int fuerzaMordida) {
        super(habitad, altura, largo, peso, nombreCientifico, color, tamañoColmillos);
        this.fuerzaMordida = fuerzaMordida;
    }

    public int getFuerzaMordida() {
        return fuerzaMordida;
    }

    @Override
    public String comer() {
        return "El Perro por su fuerza de mordida " + this.fuerzaMordida + " psi y tamaño de colmillo de " + this.getTamañoColmillos() + " puede llegar a comer carne por lo que " +
                "llega a obtener un peso de " + this.getPeso() ;
    }

    @Override
    public String dormir() {
        return "El Perro suele dormir largas horas en " + this.getHabitad();
    }

    @Override
    public String correr() {
            return "El Perro por su peso de " + this.getPeso() + ", su altura de" + this.getAltura() + ", y largo de " + this.getLargo() +", no pueden alcanza mucha velocidad";
    }

    @Override
    public String comunicarse() {
        return "El Perro por su ladrido asusta pero por su color " + this.getColor() + " no logra intimidar";
    }
}
