package com.nikki.java8.lambda;

import com.nikki.java8.lambda.models.Usuario;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class EjemploConsumer {
    public static void main(String[] args) {
        Consumer<String> consumidor = saludo -> System.out.println(saludo);
        consumidor.accept("hola");//metodo abstracto de Consumer

        //dos o mas parametros va con parentesis
        BiConsumer<String, Integer> consumidorBi = (nombre, edad) ->{
            System.out.println(nombre + ", tiene " + edad + " años");
        };
        consumidorBi.accept("Karen", 34);

        Consumer<String> consumidor2 = System.out::println;
        consumidor2.accept("hola 2");//metodo abstracto de Consumer

        List<String> nombres = Arrays.asList("andres", "luz", "miguel","paco");
        nombres.forEach(consumidor); //recibe un consumer

        Usuario usuario = new Usuario(); //un consumer no devuelve nada
        BiConsumer<Usuario, String> asignarnombre = (persona, nombre) ->{
            persona.setNombre(nombre);
        };
        asignarnombre.accept(usuario, "nikki");
        System.out.println("Nombre usuario: " + usuario.getNombre());


        BiConsumer<Usuario, String> asignarnombre2 = Usuario::setNombre;
        asignarnombre2.accept(usuario, "nikki");
        System.out.println("Nombre usuario: " + usuario.getNombre());


        Supplier<Usuario> creaUsuario = Usuario::new; //declara un suplier de tipo usuario
        Usuario  user = creaUsuario.get(); // se declara un user que va ser igual a lo que regrese el suplier
        BiConsumer<Usuario, String> asignarnombre3 = Usuario::setNombre;
        asignarnombre2.accept(user, "nikki");


        Supplier<String> proveedor = () -> {
            return "Hola mundo";
        };
        System.out.println(proveedor.get());

        Supplier<String> proveedor2 = () -> "Hola mundo";
        System.out.println(proveedor2.get());

    }
}
