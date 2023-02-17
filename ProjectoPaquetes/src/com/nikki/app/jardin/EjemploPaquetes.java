package com.nikki.app.jardin;

import com.nikki.app.hogar.ColorPelo;
import com.nikki.app.hogar.Persona;
import static com.nikki.app.hogar.Persona.saluda; //importando metodos estaticos
import static com.nikki.app.hogar.Persona.GENERO_FEMENINO; //importando metodos estaticos
import static com.nikki.app.hogar.ColorPelo.CAFE; //importando metodos estaticos


public class EjemploPaquetes {
    public static void main(String[] args) {
        Persona persona = new Persona();
        persona.setApellido("R");
        persona.setNombre("Nikki");
        //persona.setColorPelo(ColorPelo.NEGRO);
        persona.setColorPelo(CAFE);

        Perro perro = new Perro();
        perro.nombre = "Chirris";
        perro.raza = "Bulldog";

        String jugando = perro.jugar(persona); //perro jugar solo se puede en el jardin
        System.out.println("" + persona.getNombre() + " y " + perro.nombre + " estan jugando a " + jugando);

        String saludarVecinos = saluda();
        String generoPersona = GENERO_FEMENINO;
    }
}
