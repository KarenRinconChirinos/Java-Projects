package com.nikki.patrones.factory.producto;

import com.nikki.patrones.factory.PizzaProducto;

public class PizzaCaliforniaVegetariana extends PizzaProducto {

    public PizzaCaliforniaVegetariana() {
        super();
        setNombre("Pizza California Vegetariana");
        setMasa("Masa delgada Light");
        setSalsa("Salsa de BBQ Light");
        addIngredientes("Queso mozzarella");
        addIngredientes("Aceitunas");
        addIngredientes("Espinacas");
        addIngredientes("Cebolla");
        addIngredientes("Berenjena");
    }

    @Override
    public void cocinar() {
        System.out.println("Cocinando por 20 min. a 180°C");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando la pizza en reabanadas rectangulares");
    }
}
