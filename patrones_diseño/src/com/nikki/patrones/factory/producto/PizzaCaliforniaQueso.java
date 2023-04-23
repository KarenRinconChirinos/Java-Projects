package com.nikki.patrones.factory.producto;

import com.nikki.patrones.factory.PizzaProducto;

public class PizzaCaliforniaQueso extends PizzaProducto {

    public PizzaCaliforniaQueso() {
        super();
        setNombre("Pizza California Queso");
        setMasa("Masa delgada a la piedra");
        setSalsa("Salsa de tomate rucula");
        addIngredientes("Extra Queso mozzarella");
        addIngredientes("Cebolla");
        addIngredientes("Queso azul");
    }

    @Override
    public void cocinar() {
        System.out.println("Cocinando a 35 min a 100°C");
    }

    @Override
    public void cortar() {
        System.out.println("Cortar en pequeños triangulos");
    }
}
