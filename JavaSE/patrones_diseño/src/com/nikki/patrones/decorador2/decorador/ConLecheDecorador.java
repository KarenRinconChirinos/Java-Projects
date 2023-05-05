package com.nikki.patrones.decorador2.decorador;

import com.nikki.patrones.decorador2.Configurable;

public class ConLecheDecorador extends CafeDecorador{
    public ConLecheDecorador(Configurable cafe) {
        super(cafe);
    }

    @Override
    public float getPrecioBase() {
        return cafe.getPrecioBase() +  3.7f;
    }

    @Override
    public String getIngrediente() {
        return cafe.getIngrediente() + ", Leche";
    }
}
