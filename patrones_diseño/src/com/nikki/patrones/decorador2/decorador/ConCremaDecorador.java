package com.nikki.patrones.decorador2.decorador;

import com.nikki.patrones.decorador2.Configurable;

public class ConCremaDecorador extends CafeDecorador{

    public ConCremaDecorador(Configurable cafe) {
        super(cafe);
    }

    @Override
    public float getPrecioBase() {
        return cafe.getPrecioBase() + 2.5f;
    }

    @Override
    public String getIngrediente() {
        return cafe.getIngrediente() + ", Crema";
    }
}
