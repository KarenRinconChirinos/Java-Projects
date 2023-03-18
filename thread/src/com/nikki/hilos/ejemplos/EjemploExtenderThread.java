package com.nikki.hilos.ejemplos;

import com.nikki.hilos.ejemplos.threads.NombreThread;

public class EjemploExtenderThread {
    public static void main(String[] args) throws InterruptedException {
        // mas de un core - es paralelo
        Thread hilo = new Thread(new NombreThread("Jhon Doe")); //hilo - hace referencia al hilo anidao
        hilo.start(); // el start invoca al run y asi se levanta
        //Thread.sleep(100); //Thread hace referencia al hilo principal osea al main
        Thread hilo2 = new NombreThread("karen");
        hilo2.start();
        NombreThread hilo3 = new NombreThread("pepe");
        hilo3.start();
        System.out.println(hilo.getState());
    }
}
