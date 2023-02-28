package com.nikki.pooclasesabstractas.form.elementos;

abstract public class ElementoForm { //una clase con un metodo abstracto esta obligada a ser abastracta
    protected String valor;
    protected String nombre;

    public ElementoForm() {
    }

    public ElementoForm(String nombre) {
        this();
        this.nombre = nombre;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    abstract public String dibujarHtml();
}
