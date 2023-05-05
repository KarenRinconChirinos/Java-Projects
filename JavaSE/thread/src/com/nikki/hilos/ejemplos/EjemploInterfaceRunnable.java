package com.nikki.hilos.ejemplos;

import com.nikki.hilos.ejemplos.runnable.ViajeTarea;

public class EjemploInterfaceRunnable {
    public static void main(String[] args) {
        new Thread(new ViajeTarea("Isla mujeres")).start();
        new Thread(new ViajeTarea("Acapulco")).start();
        new Thread(new ViajeTarea("Puebla")).start();
        new Thread(new ViajeTarea("Veracurz")).start();
        new Thread(new ViajeTarea("Isla canarios")).start();
    }
}
