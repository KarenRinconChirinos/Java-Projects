package com.nikki;

import java.util.Map;

public class Cadena {
    private String Cadena;
    public Map<String, Integer> manipulacion(Map<String, Integer> cadena, ICadena iCadena){
        return iCadena.manipulacion(cadena);
    }
}
