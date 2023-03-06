package com.nikki.generics;

import com.nikki.poointerfaces.modelo.Cliente;
import com.nikki.poointerfaces.modelo.ClientePremium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemploGenericos {
    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("Andres", "Guz"));

        Cliente andres = clientes.get(0); // atributos generics
        Cliente[] clientes1 ={
                new Cliente("Andres", "Guz"),
                new Cliente("Karen", "Rin")
        };

        Integer[] enteros = {1,2,3};

        //METODO GENERICCO
        List<Cliente> clientes2 = fromArraytoList(clientes1); // el metodo es compatible con cualqueir tipo y lo hace generico
        List<Integer> enteros2 = fromArraytoList(enteros);//List porque eso es lo que va devolver
        clientes.forEach(System.out::println );
        enteros2.forEach(System.out::println);

        List<String> nombres = (List<String>) fromArraytoList(new String[]{
                "Pepe",
                "chirris",
                "nikki",
                "chacal"
        }, enteros);
        nombres.forEach(System.out::println);

        //Invoca la clase de tipo Cliente  y la interface comparable
        List<ClientePremium> clientePremiumList = fromArraytoList(
                new ClientePremium[]{new ClientePremium("Chacal", "Ri")});

        //COMODIN WILDCARD
        imprimirCliente(clientes);
        imprimirCliente(clientes2);
        imprimirCliente(clientePremiumList); // es implementacion de cliente hijo, no de cliente padre

        System.out.println("Maximo de 1, 9 y 4 es: " + maximo(1, 9, 4));
        System.out.println("Maximo de 3.5, 9.7 y 11.7 es: " + maximo(3, 9, 11));
        System.out.println("Maximo de zanahoria, arandanos, manzana es: " + maximo("zanahoria", "arandano", "manzana"));

    }

    // se usa <T> para trabajar con listas
    //arreglo a lista //METODO GENERICO, que permite convertir clientes, puede ser de acualqueri tipo
    public static <T> List<T> fromArraytoList(T[] c){
        return Arrays.asList(c); // convertir un arreglo a lista
    }

    //METODO GENERICO CON LIMITES (BOUNDED GENERICS)
    //Al usar extends Number, solo se a poder usa numeros primitivos como
    // byte double, float int long and short
    //Invoca la clase abstracta Number
    public static <T extends Number> List<T> fromArraytoList(T[] c){
        return Arrays.asList(c);
    }

    //METODO GENERICO CON LIMITES (BOUNDED GENERICS)
    //Al usar extends Cliente, va a ceptar cualquier tipo
    // que sea de tipo cliente y subclases de cliente
    //Invoca la clase abstracta Cliente, se puede agregar mas a un metodo
    //La interface omparable tambien acepta generico con el tipo qe la representa
    public static <T extends Cliente & Comparable<T>> List<T> fromArraytoList(T[] c){
        return Arrays.asList(c);
    }
/*
    se vuelve asi cuando se hace biytecode
    public static  List<Cliente> fromArraytoList(Cliente[] c){
        return Arrays.asList(c);
    }
*/

    //METODO GENERICO SOBRECARGADO
    //retorna una lista de tipo T, G puede ser cuqlueir tipo
    public static <T, G> List<T> fromArraytoList(T[] c, G[] g){
        for(G elemento: g){ //imprimer el g
            System.out.println(elemento);
        }
        return Arrays.asList(c); // convertir un arreglo a lista
    }

/*    //METODO COMODIN WILDCARD solo permite la classe indicad ay no hijos
    public static void imprimirCliente(List<Cliente> clientes){
        clientes.forEach(System.out::println);
    }*/

    //METODO COMODIN WILDCARD
    //? extends Cliente, pasa cualquier tipo de cliente, o clases hijass
    public static void imprimirCliente(List<? extends Cliente> clientes){
        clientes.forEach(System.out::println);
    }

    //METODOS GENERICOS CON TRES OBJETOS USADANDO COMPARABLE
    //los objetos que se pasan heredan el compareto
    // comparacion de 3 tipos de objetos
    public static <T extends Comparable<T>> T maximo(T a, T b, T c){
        T max = a;
        if(b.compareTo(max) > 0){
            max = b;
        }
        if(c.compareTo(max) > 0){
            max = c;
        }
        return max;
    }
}
