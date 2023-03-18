package com.nikki.hilos.ejemplosync;

import com.nikki.hilos.ejemplosync.runnable.Consumidor;
import com.nikki.hilos.ejemplosync.runnable.Panadero;

public class EjemploProductoConsumidor {
    public static void main(String[] args) {
        Panaderia panaderia = new Panaderia();
        new Thread(new Panadero(panaderia)).start();
        new Thread(new Consumidor(panaderia)).start();
    }
}
