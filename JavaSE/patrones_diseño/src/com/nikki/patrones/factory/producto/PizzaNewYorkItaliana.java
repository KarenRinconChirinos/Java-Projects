package com.nikki.patrones.factory.producto;

import com.nikki.patrones.factory.PizzaProducto;

public class PizzaNewYorkItaliana extends PizzaProducto {
    public PizzaNewYorkItaliana() {
        super();
        setNombre("Pizza Italiana New York");
        setMasa("Masa gruesa");
        setSalsa("Salsa de tomate italiano carne");
        addIngredientes("Queso Mozarella");
        addIngredientes("Aceitunas");
        addIngredientes("Jamon");
        addIngredientes("Choricillo");
        addIngredientes("Champiñones");
    }

    @Override
    public void cocinar() {
        System.out.println("Cocinando por 30 min a 120°C");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando la pizza en triangulos grandes");
    }
}
