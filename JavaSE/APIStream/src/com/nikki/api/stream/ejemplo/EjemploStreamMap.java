 package com.nikki.api.stream.ejemplo;

import com.nikki.api.stream.ejemplo.models.Usuario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EjemploStreamMap {
    public static void main(String[] args) {
         Stream<Usuario> nombres =Stream
                 .of("pato guz", "paco jam", "pepa mar", "pepe men")
                 .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))// el map devuelve un resultado o el dato cambiado
                 .peek(System.out::println)
                 .map(usuario -> {
                     String nombre = usuario.getNombre().toUpperCase();
                     usuario.setNombre(nombre);
                     return usuario;
                 });

        List<Usuario> lista = nombres.collect(Collectors.toList());
        lista.forEach(u -> System.out.println(u.getApellido()));
         //peek - realizar un rastreo de los elementos
    }
}
