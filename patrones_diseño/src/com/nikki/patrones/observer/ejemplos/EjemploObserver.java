package com.nikki.patrones.observer.ejemplos;

import com.nikki.patrones.observer.Corporacion;
import com.nikki.patrones.observer.Observable;

public class EjemploObserver {
    public static void main(String[] args) {
        Corporacion google = new Corporacion("Google", 1000);
        google.addObserver((observable, obj) -> {
            System.out.println("Jhon: " + observable);
        });

        google.addObserver((observable, obj)  -> {
            System.out.println("Andres: " + observable);
        });

        google.addObserver((observable, obj)  -> {
            System.out.println("Maria: " + observable);
        });
        google.modificaPrecio(2000);
    }
}
