package com.nikki.app.jardin;

import com.nikki.app.hogar.Persona;

public class Perro {
    protected String nombre;
    protected String raza;

    String jugar(Persona persona){ //metodo default porque el perro solo juega en el patio
      return persona.lanzarPelota();
    }
}
