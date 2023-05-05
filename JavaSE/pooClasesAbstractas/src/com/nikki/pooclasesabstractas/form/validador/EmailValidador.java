package com.nikki.pooclasesabstractas.form.validador;

public class EmailValidador extends  Validador{
    protected String mensaje = "el campo %s  es invalido";
    private final static String EMAIL_REGEX =  "^(.+)@(.+)$";
    //^ va a validar el string desde el comienzo de la linea
    //$ va a validar el string desde el final de la linea
    //() representa un grupo
    //. cualquier caracter
    // + se puede repetir caracter

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
        return valor.matches(EMAIL_REGEX);
    }
}
