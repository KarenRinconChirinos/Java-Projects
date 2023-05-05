package com.nikki.ejemploexcepciones;

public class Calculadora {
    public double dividir(int numerador, int divisor) throws DivisionPorZeroException{
        if(divisor == 0){
            // se personaliza la exception
            throw new DivisionPorZeroException("no se puede dividir por cero!");
        }
        return (double)numerador/(double)divisor; // tira la exception personalizada
    }

    public double dividir(String numerador, String divisor)
            throws DivisionPorZeroException,
            FormatNumeroException {
        try {
            int num = Integer.parseInt(numerador);
            int div = Integer.parseInt(divisor);
            return this.dividir(num, div);
        }catch (NumberFormatException nfe){
            throw new FormatNumeroException("debe ingresar un numero en el numerador y divisor");
        }
    }
}
