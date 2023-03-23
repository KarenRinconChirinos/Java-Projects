package com.nikki.lambda;

public class Cadena{
    private String cadena;

    public String manipulacionCadenas(String a, ICadena cadena) {
        return cadena.manipulacion(a);
    }

    /*Expresión Lambda que elimine espacios, comas y
      puntos de una frase y además la devuelva la frase
      convertida en mayúscula.*/
}
