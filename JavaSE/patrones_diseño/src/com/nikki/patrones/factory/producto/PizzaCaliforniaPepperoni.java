package com.nikki.patrones.factory.producto;

import com.nikki.patrones.factory.PizzaProducto;

public class PizzaCaliforniaPepperoni extends PizzaProducto {
    public PizzaCaliforniaPepperoni() {
        super();
        setNombre("Pizza California Pepperoni");
        setMasa("Masa gruesa a la piedra");
        addIngredientes("Pepperoni");
        addIngredientes("Extra queso mozzarella");
        addIngredientes("Aceitunas");
    }

    @Override
    public void cocinar() {
        System.out.println("Cocinando a 50 min. a 55°C");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando la pizza en pequeños rectangulos");
    }
}
