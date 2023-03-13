package com.nikki.colecciones.ejemplos.map;

import java.util.*;

public class EjemploTreeMap {
    public static void main(String[] args) {

        //Map<String, Object> persona = new TreeMap<>((a, b) -> b.compareTo(a));
        Map<String, Object> persona = new TreeMap<>(Comparator.comparing(String::length).reversed());

        //treeMap - ordenar solo las llaves de forma natural
        //persona.put(null, "1234"); no se puede porque guarda objetos
        persona.put("nombre", "Jhon");
        persona.put("apellido", "Doe");//se repite, pero coloca el ultimo
        persona.put("apellidoPaterno", "Roe");// osea este
        persona.put("email", "jhon.die@gmail.com");
        persona.put("edad", 30); //respetar el tipo de valor



        System.out.println("persona = " + persona);
        String nombre = (String) persona.get("nombre");//conversion de object a string
        System.out.println("nombre = " + nombre);


        Map<String, String> direccion = new HashMap<>();
        direccion.put("pais","USA");
        direccion.put("estado","California");
        direccion.put("ciudad","Santa Barbara");
        direccion.put("calle","One Street");
        direccion.put("numero","1243");
        persona.put("direccion", direccion); //un map con otro map
        System.out.println("direccion = " + direccion);

        //String apellidoAp = persona.remove("apellidoPaterno");
        Boolean apellidoAp = persona.remove("apellidoPaterno", "Roe");
        System.out.println("eliminado = " + apellidoAp);
        System.out.println("persona = " + persona);
    }
}
