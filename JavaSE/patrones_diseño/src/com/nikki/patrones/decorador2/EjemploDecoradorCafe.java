package com.nikki.patrones.decorador2;

import com.nikki.patrones.decorador2.decorador.ConChocolateDecorador;
import com.nikki.patrones.decorador2.decorador.ConCremaDecorador;
import com.nikki.patrones.decorador2.decorador.ConLecheDecorador;

public class EjemploDecoradorCafe {
    public static void main(String[] args) {
        Configurable cafe = new Cafe(7, "Cafe Mocha");
        ConCremaDecorador conCrema = new ConCremaDecorador(cafe);
        ConLecheDecorador conLeche = new ConLecheDecorador(conCrema);
        ConChocolateDecorador conChoco = new ConChocolateDecorador(conLeche);
        System.out.println("El precio del cafe moca es:" + conChoco.getPrecioBase());
        System.out.println("Los ingredientes:" +  conChoco.getIngrediente());

        Configurable capuchino = new Cafe(4, "Cafe Capuchino");
        conCrema = new ConCremaDecorador(capuchino);
        conLeche = new ConLecheDecorador(conCrema);
        System.out.println("El precio del capuchino es: " + conLeche.getPrecioBase());
        System.out.println("Los ingredientes " + conLeche.getIngrediente());

        Configurable espresso = new Cafe(3,"Cafe Expresso");
        System.out.println("El precio del cafe Espresso es " + espresso.getPrecioBase());
        System.out.println("Los ingredientes del Cafe expresso es: " + espresso.getIngrediente());



    }
}
