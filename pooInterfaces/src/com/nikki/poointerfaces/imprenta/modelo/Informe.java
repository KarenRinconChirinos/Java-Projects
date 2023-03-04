package com.nikki.poointerfaces.imprenta.modelo;

public class Informe extends Hoja implements Imprimible{
    private Persona autor;
    private Persona revisor;

    public Informe(Persona autor, Persona revisor,String contenido) {
        super(contenido);
        this.autor = autor;
        this.revisor =  revisor;
    }

    @Override
    public String imprimir() { //sobreescribe el imprimir de interfaz y de hoja
        return "Informe escrito por " + this.autor +
                "\nRevisado por " + this.revisor +
                "\n" + this.contenido; //viene de la clase padre y lo podemos usar porque es protected
    }
}
