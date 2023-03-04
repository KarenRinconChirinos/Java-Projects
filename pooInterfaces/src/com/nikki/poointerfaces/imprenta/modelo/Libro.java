package com.nikki.poointerfaces.imprenta.modelo;

import java.util.ArrayList;
import java.util.List;

public class Libro implements  Imprimible{ //libro no es una hoja por lo que no se puede heredar, es una coleccion de hojas
    private List<Imprimible> paginas;
    private Persona autor;
    private String titulo;
    private Genero genero;

    public Libro(Persona autor, String titulo, Genero genero) {
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
        this.paginas = new ArrayList<>(); //inicializa el array cuando se invoca al constructor
    }

    public Libro addPagina(Imprimible hoja){
        paginas.add(hoja);
        return this;
    }

    @Override
    public String imprimir(){
        StringBuilder stringBuilder = new StringBuilder("Titulo: ");
        stringBuilder.append(this.titulo + "\n");
        stringBuilder.append("Autor: " + this.autor.getNombre() + " " + this.autor.getApellido());
        stringBuilder.append("\nGenero: " + this.genero);
        for (Imprimible pag: this.paginas){
            stringBuilder.append("\n" + pag.imprimir());
        }
        return stringBuilder.toString();
    }
}
