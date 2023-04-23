package com.nikki.patrones.factory;

import com.nikki.patrones.factory.producto.PizzaNewYorkItaliana;
import com.nikki.patrones.factory.producto.PizzaNewYorkPepperoni;
import com.nikki.patrones.factory.producto.PizzaNewYorkVegetariana;

public class PizzeriaNewYorkFactory extends PizzeriaZonaAbstractFactory{
    @Override
    PizzaProducto crearPizza(String tipo) {
        PizzaProducto producto;
        producto = null;
        switch (tipo){
            case "vegetariana" ->
                    producto = new PizzaNewYorkVegetariana();
            case "pepperoni" ->
                    producto = new PizzaNewYorkPepperoni();
            case "italiana" ->
                    producto = new PizzaNewYorkItaliana();
        }
        return producto;
    }
}
