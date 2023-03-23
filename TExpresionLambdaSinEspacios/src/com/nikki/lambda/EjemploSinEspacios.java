package com.nikki.lambda;

import java.util.function.Function;

public class EjemploSinEspacios {
    public static void main(String[] args) {
        /*Expresión Lambda que elimine espacios, comas y
         puntos de una frase y además la devuelva la frase
         convertida en mayúscula.*/
        ICadena cadenaOp = a -> a.toUpperCase()
                                .replace(".", "")
                                .replace(",", "")
                                .replace(" ", "");
        Cadena cadena = new Cadena();
        System.out.println("Cadena: \n" +
                cadena.manipulacionCadenas("Los perros son animales mamíferos y, " +
                        "aunque cada raza puede tener diferentes características y " +
                        "habilidades, la mayoría de los perros tienen dientes grandes " +
                        "y fuertes, lo que les permite comer diferentes tipos de alimentos " +
                        "y adquirir unos músculos fuertes y habilidades importantes para su " +
                        "supervivencia, como correr", cadenaOp));
    }
}
