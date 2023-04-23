package com.nikki.patrones.decorator.decorador;

import com.nikki.patrones.decorator.Formateable;

public class RemplazarEspacioDecorador extends TextoDecorador{
    public RemplazarEspacioDecorador(Formateable texto) {
        super(texto);
    }

    @Override
    public String darFormato() {
        return texto.darFormato().replace(" ", "_");
    }
}
