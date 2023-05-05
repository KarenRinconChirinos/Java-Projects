package com.nikki.archivos.ejemplos;

import com.nikki.archivos.ejemplos.service.ArchivoServicio;

public class EjemploLeerArchivo {
    public static void main(String[] args) {
        String nombreArchivo = "C:\\Users\\cabal\\projects_git\\ManejodeArchivos\\java.txt";
        ArchivoServicio servicio = new ArchivoServicio();
        System.out.println(servicio.leerArchivo(nombreArchivo));
    }
}
