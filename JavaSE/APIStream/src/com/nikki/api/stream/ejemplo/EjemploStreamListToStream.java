package com.nikki.api.stream.ejemplo;

import com.nikki.api.stream.ejemplo.models.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

public class EjemploStreamListToStream {
    public static void main(String[] args) {
        List<Usuario> lista = new ArrayList<>();
        lista.add(new Usuario("Andres", "Guz"));
        lista.add(new Usuario("Luci", "Mar"));
        lista.add(new Usuario("Pepe", "Fer"));
        lista.add(new Usuario("Cata", "Per"));
        lista.add(new Usuario("Lalo", "Mena"));
        lista.add(new Usuario("Exequiel", "Doe"));
        Stream<String> nombres = lista.stream().map( u -> u.getNombre()
                                    .toUpperCase()
                                    .concat(" ")
                .concat(u.getApellido().toUpperCase()))
                .flatMap(nombre ->{
                    if (nombre.contains("bruce".toUpperCase())){
                        return Stream.of(nombre);
                    }
                    return Stream.empty();
                })
                .map(String::toLowerCase)
                .peek(System.out::println); //crea una lista en stream

        System.out.println(nombres.count());
    }
}
