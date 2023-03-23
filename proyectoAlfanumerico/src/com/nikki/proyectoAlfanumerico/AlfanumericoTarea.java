package com.nikki.proyectoAlfanumerico;

public class AlfanumericoTarea implements Runnable{
    private Tipo tipo;
    private String[] abecedario = {"A", "B", "C", "D", "E", "F",
                                    "G", "H", "I", "J", "K", "L",
                                    "M", "N", "O", "P", "Q", "R",
                                    "S", "T", "V", "U", "W", "X",
                                    "Y", "Z"};
    private Integer[] numeros = {1,2,3,4,5,6,7,8,9,10};

    public AlfanumericoTarea(Tipo tipo) {
        this.tipo = tipo;
    }

    public Tipo getTipo() {
        return tipo;
    }

    @Override
    public void run() {
        if(this.tipo == Tipo.NUMERO){
            for(int i = 0; i < 10; i++){
                System.out.println(numeros[i]);
            }
        }else if(this.tipo == Tipo.LETRA){
            for(int i = 0; i < abecedario.length; i++){
                System.out.println(abecedario[i]);
            }
        }
    }

    /*Si el tipo es NUMERO, mostrara los números del 1 al 10,
     excluyente el último.

    Si el tipo es LETRA, mostrar las letras de la 'A' a la 'Z'
    , inclusivo el último.*/
}
