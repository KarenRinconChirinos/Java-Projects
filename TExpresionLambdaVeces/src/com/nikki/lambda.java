package com.nikki;

import java.util.HashMap;
import java.util.Map;

public class lambda {
    public static void main(String[] args) {
        ICadena veces = cad -> {
            Map<String, Integer> resultado = new HashMap();
            resultado.put(cad, max);
            return resultado;
        };
        Cadena cadena = new Cadena();
        System.out.println(cadena.manipulacion("hola hol d hola golla hola ", veces));
    }
}
