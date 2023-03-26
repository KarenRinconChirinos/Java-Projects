package com.nikki.api.stream.ejemplo;

import com.nikki.api.stream.ejemplo.models.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class EjemploStreamParallel {
    public static void main(String[] args) {
        List<Usuario> lista = new ArrayList<>();
        lista.add(new Usuario("Andres", "Guz"));
        lista.add(new Usuario("Luci", "Mar"));
        lista.add(new Usuario("Pepe", "Fer"));
        lista.add(new Usuario("Cata", "Per"));
        lista.add(new Usuario("Lalo", "Mena"));
        lista.add(new Usuario("Exequiel", "Doe"));
        Long t1 = System.currentTimeMillis();
        String nombres = lista.stream()
                .parallel()
                .map( u -> u.toString().toUpperCase().concat(" ")
                .concat(u.getApellido().toUpperCase()))
                .peek(n -> {
                    System.out.println("Nombre thread " +
                            Thread.currentThread() + " - " + n);
                })
                .flatMap(nombre ->{
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (nombre.contains("bruce".toUpperCase())){
                        return Stream.of(nombre);
                    }
                    return Stream.empty();
                })
                .findAny().orElse(""); //crea una lista en stream

        long t2 = System.currentTimeMillis();
        System.out.println("Tiempo total:" + (t2 - t1));
        System.out.println(nombres);
    }
}
