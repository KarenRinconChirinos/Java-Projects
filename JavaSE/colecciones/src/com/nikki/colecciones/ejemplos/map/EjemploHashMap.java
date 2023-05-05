package com.nikki.colecciones.ejemplos.map;

import java.util.*;

public class EjemploHashMap {
    public static void main(String[] args) {
        //clave - valor
        //las claves no se pueden repetir
        //los valores si se pueden repetir
        //Map es el padre //HashMap es el hijo
        //Map<String, String> persona = new HashMap<>();
        Map<String, Object> persona = new HashMap<>();

        System.out.println("contiene elementos: " + !persona.isEmpty());

        //usa el metodo hascpde e equals para identificar si una llave es igual o no, atraves de un vaor
        //contains value, contains key usan hashcode como equals
        //el hashcode detecta que son iguales, va llamar al metodo equals para verificar si es igual o no
        persona.put(null, "1234");
        persona.put(null, "12345");
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

        //metodo clear borra todos valores asociativos a l map
        //contains preguntar si existe o no
        //remove eliminar a traves de una key
        //remplace - remplazar
        //remplace un clave el valor viejo por uno nuevo
        //size- cantidad de elementos que existen

        //String apellidoAp = persona.remove("apellidoPaterno");
        Boolean apellidoAp = persona.remove("apellidoPaterno", "Roe");
        System.out.println("eliminado = " + apellidoAp);
        System.out.println("persona = " + persona);

        Map<String, String> direccionPersona = (Map<String, String>) persona.get("direccion");
        String pais = direccionPersona.get("pais");
        String ciudad = direccionPersona.get("ciudad");
        // si fuera get mandaria null
        String barrio = direccionPersona.getOrDefault("barrio", "valorxdefecto/getordefault");
        System.out.println("barrio = " + barrio);
        
        //metodo contais
        boolean b2 = persona.containsKey("apellidoPaterno");
        System.out.println("b2 = " + b2);
        b2 = persona.containsValue("Doe");
        System.out.println("b2 = " + b2);

        Collection<Object> valores = persona.values(); // tipo object porque es generico
        for(Object valor: valores){
            System.out.println("valor = " + valor);
        }

        System.out.println("============== ITERAR CON FOR EACH keyset ====================");
        Set<String> llaves = persona.keySet();
        for(String llave : llaves){
            System.out.println("llave = " + llave);
        }

        System.out.println("============== ITERAR CON entrySet ====================");
        for(Map.Entry<String, Object> par : persona.entrySet()){
            Object valor = par.getValue();
            if(valor instanceof Map){
                String nom = (String) persona.get("nombre");
                Map<String, String> direccionMao =  (Map<String, String>) valor;
                for(Map.Entry<String, String> parDir: direccionMao.entrySet()){
                    System.out.println(parDir.getKey() + " -> " + parDir);
                }
            }else{
                System.out.println(par.getKey() + " - " + par.getValue());
            }
        }


        System.out.println("============== ITERAR CON FOR keyset====================");
        for(String llave: persona.keySet()){
            Object valor = persona.get(llave);
            if(valor instanceof Map){
                String nom = (String) persona.get("nombre");
                Map<String, String> direccionMao =  (Map<String, String>) valor;
                System.out.println("El pais de " + nom + ":"
                + direccionMao.get("pais"));
                System.out.println("La ciudad de " + nom + ": " + direccionMao.get("ciudad"));
                System.out.println("El estado de " + nom + ": " + direccionMao.get("estado"));

            }else{
                System.out.println(llave + " - " +  valor);
            }
        }

        System.out.println("============== ITERAR CON FOR EACH LAMBDA JAVA 8====================");
        persona.forEach((llave,valor) ->{
            System.out.println(llave + " - " +  valor);
        });

        System.out.println("total: " + persona.size());
        persona.replace("nombre", "andres");
        //cambiar el viejo por el nuevo y retorna unn boolean si lo hizo o no
        persona.replace("nombre", "juan","andres");

        System.out.println("persona: " + persona);
    }
}
