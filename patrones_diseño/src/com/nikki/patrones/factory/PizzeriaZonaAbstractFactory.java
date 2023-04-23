package com.nikki.patrones.factory;

abstract public class PizzeriaZonaAbstractFactory {
    private String tipo;
    private String nombre;

    //pizzeria son las fabricas
    public PizzaProducto ordenarPizza(String tipo, String nombre){
        PizzaProducto pizza = crearPizza(tipo);
        this.tipo = tipo;
        this.nombre = nombre;
        System.out.println("Fabricando la pizza " + pizza.getNombre());
        pizza.preparar();
        pizza.cocinar();
        pizza.cortar();
        pizza.empaquetar();
        return  pizza;
    }

    abstract PizzaProducto crearPizza(String tipo);

}
