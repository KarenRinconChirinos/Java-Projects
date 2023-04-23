package com.nikki.patrones.factory.producto;

import com.nikki.patrones.factory.PizzaProducto;

public class PizzaNewYorkPepperoni extends PizzaProducto {
    public PizzaNewYorkPepperoni() {
        super();
        setNombre("Pizza Pepperoni New York");
        setMasa("Masa delgada a la piedra");
        setSalsa("Salsa de tomate");
        addIngredientes("Queso mozzarella");
        addIngredientes("Extra pepperoni");
        addIngredientes("Aceitunas");
    }

    @Override
    public void cocinar() {
        System.out.println("Cocinando por 40 minutos a 90°C");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando la pizza en triangulos");
    }
}
