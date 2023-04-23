package com.nikki.datetime.ejemplos;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;

public class EjemploCalcularFechaNacimiento {
    public static void main(String[] args) {
        String f = "1999-06-05";
        LocalDate fechaNacimiento = LocalDate.parse(f);
        LocalDate fechaActual = LocalDate.now();
        Period edad = Period.between(fechaNacimiento, fechaActual);
        System.out.println("edad = " + edad.getYears());
    }
}
