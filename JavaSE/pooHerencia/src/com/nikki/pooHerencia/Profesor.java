package com.nikki.pooHerencia;

public class Profesor extends Persona {
    private String asignatura;

    public Profesor(){
        System.out.println("Profesor:  inicializando constructor");
    }

    public Profesor(String nombre, String apellido){
        super(nombre,apellido);
    }

    public Profesor(String nombre, String apellido, String asignatura){
        super(nombre, apellido);
        this.asignatura = asignatura;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    @Override
    public String saludar(){
        return "Buenas tardes, soy profesor y mi nombre es "
                + getNombre() + " de la asignatura de "
                + getAsignatura();
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nasignatura='" + asignatura + '\'';
    }
}
