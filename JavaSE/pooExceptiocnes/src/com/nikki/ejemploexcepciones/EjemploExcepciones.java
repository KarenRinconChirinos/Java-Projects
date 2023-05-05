package com.nikki.ejemploexcepciones;

import javax.swing.*;

public class EjemploExcepciones {
    public static void main(String[] args) {

        Calculadora calculadora = new Calculadora();
        String denominador = JOptionPane.showInputDialog("Ingrese un entero denominador: ");
        String numerador = JOptionPane.showInputDialog("Ingrese un entero numerador: ");

        int den, num;
        double division;
        try{
            den = Integer.parseInt(denominador);
            num = Integer.parseInt(numerador);

            /*division = calculadora.dividir(num , den);
            //int division = 10/divisor;
            System.out.println("division = " + division); //se interrumpe y no se va imprimir
            */
            double division2 = calculadora.dividir(numerador, denominador);
            System.out.println(" division2 = " + division2);
        }catch (FormatNumeroException fne){
            System.out.println("Se detecto una excepcion: ingrese un numero valido: " + fne.getMessage());
            fne.printStackTrace(System.out); // de forma implicita se imprime en onsola y
        }
        catch (DivisionPorZeroException e){ // e ES UN TIPO GENERICO OSEA PARA TODAS LAS EXCEPTIONES
            // ES MEJOR PONER LA EXCEPTCION POR U TIPO
            System.out.println("Capturamos la exception en tiempo de ejecucion = " + e.getMessage());
            main(args);
        }finally {
            //codificar de una tarea que se va ejecutar simepreocurra o no ocurra el error
            System.out.println("Es opcional, pero se ejecuta simepre con excepcion o sin");
        }
        System.out.println(" Continuamos con la ejecucion ");

    }
}
