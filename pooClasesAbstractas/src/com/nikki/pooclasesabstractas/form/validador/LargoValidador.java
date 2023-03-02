package com.nikki.pooclasesabstractas.form.validador;

import com.nikki.pooclasesabstractas.form.validador.mensaje.IMensajeFormateable;

public class LargoValidador extends Validador implements IMensajeFormateable {

    protected String mensaje = "el campo %s debe tener minimo %d caracters y maximo %d caracteres";
    private int min;
    private int max =  Integer.MAX_VALUE;

    public LargoValidador() {
    }

    public LargoValidador(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setMax(int max) {
        this.max = max;
    }

    @Override
    public void setMensaje(String mensaje) {
        this.mensaje =  mensaje;
    }

    @Override
    public String getMensaje() {
        return mensaje;
    }

    @Override
    public boolean esValido(String valor) {
        //con string.forat cambiamos los valores de %d
        this.mensaje =  String.format(this.mensaje,"", this.min, this.max);
        if( valor == null){
            //es valido
            return true;
        }
        int largo =  valor.length();
        return (largo >= min && largo <= max);
    }

    @Override
    public String getMensajeFormateado(String campo) { //contrato que se cumple
        return String.format(this.mensaje, campo, this.min, this.max );
    }

}
