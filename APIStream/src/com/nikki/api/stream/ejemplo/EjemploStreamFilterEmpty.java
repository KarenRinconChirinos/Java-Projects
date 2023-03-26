 package com.nikki.api.stream.ejemplo;

import java.util.stream.Stream;

 public class EjemploStreamFilterEmpty {
     public static void main(String[] args) {
          long count = Stream
                  .of("pato guz", "", "pepa mar", "pepe men"
                          , "pepe maer")
                  .filter(String::isEmpty)//evitar el nullpointer exception si es que no se encuetra con el orElse
                  .peek(System.out::println)
                  .count();
         System.out.println("count = " + count);

     }
 }
