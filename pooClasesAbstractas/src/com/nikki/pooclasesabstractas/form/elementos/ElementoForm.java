package com.nikki.pooclasesabstractas.form.elementos;

import com.nikki.pooclasesabstractas.form.validador.LargoValidador;
import com.nikki.pooclasesabstractas.form.validador.Validador;
import com.nikki.pooclasesabstractas.form.validador.mensaje.IMensajeFormateable;

import java.util.ArrayList;
import java.util.List;

abstract public class ElementoForm { //una clase con un metodo abstracto esta obligada a ser abastracta
    protected String valor;
    protected String nombre;
    private List<Validador> validadores;
    private List<String> errores;

    public ElementoForm() {
        this.validadores = new ArrayList<>();
        this.errores = new ArrayList<>();
    }

    public ElementoForm(String nombre) {
        this();
        this.nombre = nombre;
    }

    public ElementoForm addValidador(Validador validador){
        this.validadores.add(validador);
        return this;
    }


    public List<String> getErrores() {
        return errores;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public boolean esValido(){
        for(Validador v: validadores){
            if(!v.esValido(this.valor)){
                if( v instanceof IMensajeFormateable){// no se necesita varios validadroes para la calse con la interfaz basta
                    this.errores.add(((IMensajeFormateable) v).getMensajeFormateado(nombre));
                }else{
                    this.errores.add(String.format(v.getMensaje(), this.nombre));
                }
            }
        }
        return this.errores.isEmpty();
    }

    abstract public String dibujarHtml();
}
