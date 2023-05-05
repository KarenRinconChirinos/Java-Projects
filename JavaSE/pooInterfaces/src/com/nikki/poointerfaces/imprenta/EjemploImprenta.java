package com.nikki.poointerfaces.imprenta;

import com.nikki.poointerfaces.imprenta.modelo.*;
import static com.nikki.poointerfaces.imprenta.modelo.Imprimible.TEXTO;
import static com.nikki.poointerfaces.imprenta.modelo.Imprimible.imprimir;

public class EjemploImprenta {
    public static void main(String[] args) {
        Curriculum cv = new Curriculum(new Persona("Maria" , "Martinez"), "Ingeniero en computacion", "Carrera academica, experiencias laborales");
        cv.addExperiencias("Java")
                .addExperiencias("Python")
                .addExperiencias("Spring");

        Informe informe = new Informe(new Persona("Mario", "Escobedo"), new Persona("Norman" , "Fashnat"), "En este informe se trata acerca de los microservicios en diversas tecnologias");
        Imprimible.imprimir(cv);
        Imprimible.imprimir(informe);

        Libro libro = new Libro(new Persona("Antonio", "Gil"), "Patrones de diseño", Genero.EDUCACION);
        libro.addPagina(new Pagina("Prefacio"))
                .addPagina(new Pagina("Introducción"))
                .addPagina(new Pagina("Capitulo 1: Patron Singleton"))
                .addPagina(new Pagina("Resumen de el Patron Singleton"))
                .addPagina(new Pagina("Capitulo 2: Patron Observador"))
                .addPagina(new Pagina("Capitulo 3: Patron Factory"));
        //imprimir(libro); no se puede por que es un metodo
        System.out.println();
        Imprimible.imprimir(libro);

        System.out.println();
        System.out.println(TEXTO); //una constante que viene de Imprimible interface


        //CLASE ANONIMA
        // no s epuede reutilizar
        imprimir(new Imprimible() {
            @Override
            public String imprimir() {
                return Imprimible.super.imprimir();
            }
        });


    }


    /*public static void imprimir(Hoja imprimible){
        System.out.println(imprimible.imprimir());
    }*/
}
