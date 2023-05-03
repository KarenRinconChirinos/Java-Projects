package com.nikki.appmockito.ejemplos.services;

import com.nikki.appmockito.ejemplos.models.Examen;

import java.util.Arrays;
import java.util.List;

public class Datos {
    //constantes en mayusculas
    public final static List<Examen> EXAMENES = Arrays.asList(
            new Examen(5L, "Matematicas")
            , new Examen(6L, "Lenguaje")
            , new Examen(7L, "Hisotria"));
    public final static List<String> PREGUNTAS = Arrays.asList(
            "aritmetica",
            "integrales",
            "derivadas",
            "trigonometria",
            "geometria");

}
