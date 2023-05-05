package com.nikki.patrones.factory.ejemplo;

import com.nikki.patrones.factory.PizzaProducto;
import com.nikki.patrones.factory.PizzeriaCaliforniaFactory;
import com.nikki.patrones.factory.PizzeriaNewYorkFactory;
import com.nikki.patrones.factory.PizzeriaZonaAbstractFactory;

public class EjemploFactory {
    public static void main(String[] args) {
        PizzeriaZonaAbstractFactory pizzeriaNewYork = new PizzeriaNewYorkFactory();
        PizzeriaZonaAbstractFactory pizzeriaCalifornia = new PizzeriaCaliforniaFactory();


        PizzaProducto pizza = pizzeriaCalifornia.ordenarPizza("queso", " Chris");
        System.out.println("Ban  se le entrego su " + pizza.getNombre());

        pizza = pizzeriaNewYork.ordenarPizza("pepperoni", "Andy");
        System.out.println("QAD  se le entrego su " + pizza.getNombre());

        pizza = pizzeriaCalifornia.ordenarPizza("vegetariana", "Mar");
        System.out.println("Marco  se le entrego su " + pizza.getNombre());

        pizza = pizzeriaNewYork.ordenarPizza("vegetariana", "Ariel");
        System.out.println("Jaun  se le entrego su " + pizza.getNombre());

        pizza = pizzeriaCalifornia.ordenarPizza("pepperoni", "Joel");
        System.out.println("Ren  se le entrego su " + pizza.getNombre());

        System.out.println(pizza);

    }
}
