package com.nikkianotaciones.ejemplo;

import com.nikkianotaciones.ejemplo.models.Producto;
import com.nikkianotaciones.ejemplo.procesador.JsonSerializador;

import java.time.LocalDate;

public class EjemploAnotacion {
    public static void main(String[] args) {
        Producto prod = new Producto();
        prod.setFecha(LocalDate.now());
        prod.setNombre("mesa centro ROBle");
        prod.setPrecio(1000l);
        System.out.println("json: " + JsonSerializador.convertirJson(prod));
    }
}
