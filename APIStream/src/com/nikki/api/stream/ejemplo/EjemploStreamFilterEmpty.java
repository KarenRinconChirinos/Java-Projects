 package com.nikki.api.stream.ejemplo;

import com.nikki.api.stream.ejemplo.models.Usuario;

import java.util.Optional;
import java.util.stream.Stream;

 public class EjemploStreamFilterEmpty {
     public static void main(String[] args) {
          Stream<Usuario> nombres =Stream
                  .of("pato guz", "paco jam", "pepa mar", "pepe men"
                          , "pepe maer")
                  .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))// el map devuelve un resultado o el dato cambiado
                  .filter(u -> u.getNombre().equals("pepe"))//evitar el nullpointer exception si es que no se encuetra con el orElse
                  .peek(System.out::println);

          //objeto optional permite anidar para obtenerlo, si esta vacio, filtrarlo
         Optional<Usuario> usuario = nombres.findFirst(); //buscar el primero

         if(usuario.isPresent()){
             System.out.println(usuario.get());//convertimos a un solo objeto de tipo usuario
         }else{
             System.out.println("no se encontro el objeto ");
         }


         //orElseGet es un supplier solo devuelve
         //System.out.println(usuario.orElseGet(() -> new Usuario("paz", "ron")).getNombre());
         //System.out.println(usuario.orElse(new Usuario("paz", "ron")).getNombre());//convertimos a un solo objeto de tipo usuario
          //peek - realizar un rastreo de los elementos
     }
 }
