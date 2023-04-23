package com.nikki.patrones.factory;

import com.nikki.patrones.factory.producto.PizzaCaliforniaPepperoni;
import com.nikki.patrones.factory.producto.PizzaCaliforniaQueso;
import com.nikki.patrones.factory.producto.PizzaCaliforniaVegetariana;

public class PizzeriaCaliforniaFactory  extends PizzeriaZonaAbstractFactory{
    @Override
    PizzaProducto crearPizza(String tipo) {
        PizzaProducto producto = null;
        switch (tipo){
            case "queso" ->
                    producto = new PizzaCaliforniaQueso();
            case "pepperoni" ->
                    producto = new PizzaCaliforniaPepperoni();
            case "vegetariana" ->
                    producto = new PizzaCaliforniaVegetariana();
        }
        return producto;
    }
}
