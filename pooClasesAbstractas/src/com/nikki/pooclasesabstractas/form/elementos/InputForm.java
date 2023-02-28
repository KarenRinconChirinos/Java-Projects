package com.nikki.pooclasesabstractas.form.elementos;

public class InputForm extends ElementoForm{

    private String tipo = "text";

    public InputForm(String nombre) {
        super(nombre);
    }

    public InputForm(String nombre, String tipo) {
        super(nombre);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String dibujarHtml() { //clase abstract que es padre
        return "<input type='"+ this.tipo
                +"' name='"+ this.nombre //son protected
                +"' values='"+ this.valor + "' >";
    }
}
