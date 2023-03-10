package com.nikki.colecciones.ejemplos.modelo;

public class Alumno implements  Comparable<Alumno>{ //Implementa la interfaz comparable
    //se le da el objeto Alumno a la interfaz para hacer el cast
    private String nombre;
    private Integer nota;

    public Alumno() {
    }

    public Alumno(String nombre, Integer nota) {
        this.nombre = nombre;
        this.nota = nota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return  "\n" + "nombre: " + nombre +
                " nota: " + nota;
    }

    @Override
    public int compareTo(Alumno a) {
        /*if(this.nombre == null){
            return 0;
        }*/
        if(this.nota == a.nota){
            return 0;
        }else if(this.nota > a.nota){
            return 1;
        }else if(this.nota < a.nota){
            return -1;
        }

        /*if(this.nota == null){
            return 0;
        }*/
        return this.nombre.compareTo(a.nombre);
    }
}
