package com.nikki.patrones.observer.ejemplos;

import com.nikki.patrones.observer.UsuarioRepositorio;

public class EjemploObserver2 {
    public static void main(String[] args) {
        UsuarioRepositorio repoUs = new UsuarioRepositorio();
        repoUs.addObserver((observable, obj)  -> {
            System.out.println("Enviando un email al usuario"  + obj);
        });
        repoUs.addObserver((observable, obj)  -> {
            System.out.println("Enviando un  email al administrador");
        });
        repoUs.addObserver((observable, obj)  -> {
            System.out.println("Guardando info del usuario " + obj +
                    "en el logs");
        });

        repoUs.crearUsuario("Andres");

    }
}
