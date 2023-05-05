package com.nikki.proyectoAlfanumerico;

public class EjemploAlfanumerico {
    public static void main(String[] args) {
        new Thread(new AlfanumericoTarea(Tipo.LETRA)).start();
        new Thread(new AlfanumericoTarea(Tipo.NUMERO)).start();

    }
}
