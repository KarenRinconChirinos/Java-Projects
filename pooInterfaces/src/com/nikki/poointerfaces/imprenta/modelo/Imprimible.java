package com.nikki.poointerfaces.imprenta.modelo;

public interface Imprimible {
    final static String TEXTO = "Imprimiendo un valor por defecto";
    //osea se puede imprimir una hoja, una pagina, una camisa osea impresion en tela
    default String imprimir(){
        return TEXTO;
    }; // no relaciones // tine que ser publico o default para que sean utilizados por las demas clases
    //


    static void imprimir(Imprimible imprimible){
        System.out.println(imprimible.imprimir());
    }
}
