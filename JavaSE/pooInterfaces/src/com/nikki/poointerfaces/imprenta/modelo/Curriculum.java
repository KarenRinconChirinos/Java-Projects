package com.nikki.poointerfaces.imprenta.modelo;

import java.util.ArrayList;
import java.util.List;

public class Curriculum extends Hoja implements Imprimible{
    private Persona persona;
    private String carrera;
    private List<String> experiencias;
    public Curriculum(Persona persona, String carrera,String contenido) {
        super(contenido);
        this.persona = persona;
        this.carrera = carrera;
        this.experiencias = new ArrayList<>();
    }

    public Curriculum addExperiencias(String ex){
        this.experiencias.add(ex);
        return this;
    }

    @Override
    public String imprimir() {
        StringBuilder stringBuilder = new StringBuilder("Nombre: ");
        stringBuilder.append(this.persona).append("\n")
                .append("Resumen: \n" + this.contenido)
                .append("\n" )
                .append("Profesion: " + this.carrera + "\n")
                .append("Experiencias: \n");
        for (String exp: this.experiencias){
            stringBuilder.append("* " + exp).append("\n");
        }
        return stringBuilder.toString();
    }
}
