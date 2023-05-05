package com.nikki.patrones.decorator.decorador;

import com.nikki.patrones.decorator.Formateable;
import com.nikki.patrones.decorator.Texto;

public class EjemploDecorador {
    public static void main(String[] args) {
        Formateable texto = new Texto("Hola que tal andres!");

        MayusculaDecorador mayusculaDecorador = new MayusculaDecorador(texto);
        ReversaDecorador reversaDecorador = new ReversaDecorador(mayusculaDecorador);
        SubrayadoDecorador subrayadoDecorador = new SubrayadoDecorador(reversaDecorador);

        System.out.println(subrayadoDecorador.darFormato());
    }
}
