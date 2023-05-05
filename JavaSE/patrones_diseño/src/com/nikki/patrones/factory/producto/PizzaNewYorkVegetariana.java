package com.nikki.patrones.factory.producto;

import com.nikki.patrones.factory.PizzaProducto;

public class PizzaNewYorkVegetariana extends PizzaProducto {
    public PizzaNewYorkVegetariana() {
        super();
        super.setNombre("Pizza vegetariana New York");
        setMasa("Masa integral vegana");
        setSalsa("Salsa de tomate");
        addIngredientes("Queso vegano");
        addIngredientes("Tomate");
        addIngredientes("Aceitunas");
        addIngredientes("Espinacas");
        addIngredientes("Berenjenas");
    }

    @Override
    public void cocinar() {
        System.out.println("Cocinando por 25 min a 150 °C");
    }

    @Override
    public void cortar() {
        System.out.println("Cortar la pizza en rebanadas cuadradas");
    }
}
