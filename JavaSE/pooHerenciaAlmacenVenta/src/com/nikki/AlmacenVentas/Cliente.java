package com.nikki.AlmacenVentas;

public class Cliente extends Persona{
    private int numero;


    public Cliente(String nombre, int edad, int numero) {
        super(nombre, edad);
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
