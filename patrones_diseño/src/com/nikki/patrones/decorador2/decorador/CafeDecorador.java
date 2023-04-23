package com.nikki.patrones.decorador2.decorador;

import com.nikki.patrones.decorador2.Configurable;

abstract public class CafeDecorador implements Configurable {
    protected Configurable cafe;

    public CafeDecorador(Configurable cafe) {
        this.cafe = cafe;
    }
}
