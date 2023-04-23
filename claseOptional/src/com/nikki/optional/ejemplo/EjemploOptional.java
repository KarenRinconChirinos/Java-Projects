package com.nikki.optional.ejemplo;

import java.util.Optional;

public class EjemploOptional {
    public static void main(String[] args) {
        String nombre = "Andres"; // se puede usar para cualquier tipo de referencia
        Optional<String> opt = Optional.of(nombre); //pasar un objeto y no permite null
        System.out.println("opt = " + opt);
        System.out.println(opt.isPresent()); //retorna un booleano
        if(opt.isPresent()){
            System.out.println("Hola " + opt.get()); // el get es importante en validaciones despues de un if para verificar que este presete

        }

        System.out.println(opt.isEmpty());

        opt.ifPresent(v -> System.out.println("Hola = " + v));

        nombre = null;//ejemplo de la exception con el null
        opt = Optional.of(nombre);
        opt = Optional.ofNullable(nombre); //evita el null
        System.out.println(opt.isPresent());
        System.out.println(opt.isEmpty());
        opt.ifPresent(v -> System.out.println("Hola " + v ));// usando if
        opt.ifPresentOrElse(v -> System.out.println("Hola " + v ), () ->{
            System.out.println("No esta presente o esta vacio");
        }); //usando ifelse

        Optional<String> optEmpty = Optional.empty();
        System.out.println("optEmpty = " + optEmpty);
        System.out.println(optEmpty.isPresent());

    }
}
