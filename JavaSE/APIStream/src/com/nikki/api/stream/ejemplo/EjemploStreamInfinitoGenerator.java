package com.nikki.api.stream.ejemplo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class EjemploStreamInfinitoGenerator {
    public static void main(String[] args) {
        //Stream.generate permite crear un flujo infinito y tambien se le puede dar un limite
        AtomicInteger contador = new AtomicInteger();
        Stream.generate(() -> {
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return contador.incrementAndGet();
                })
                .limit(3)
                .forEach(System.out::println);
    }
}
