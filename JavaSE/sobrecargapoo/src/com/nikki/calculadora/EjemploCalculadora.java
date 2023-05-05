package com.nikki.calculadora;
import static com.nikki.calculadora.Calculadora.*;
public class EjemploCalculadora {
    public static void main(String[] args) {
        System.out.println("suma int: " + sumar(3,2));
        System.out.println("suma int varargs: " + sumar(3,2, 4, 2 ,1 , 4));
        System.out.println("suma int varargs: " + sumar(3,2, 7, 8,9,1, 6,7));
        System.out.println("suma float varargs: " + sumar(4f,2f, 5f, 2f ,2f , 5f));
        System.out.println("suma double varargs: " + sumar(3d, 6d, 2d ,2d , 7d));

        System.out.println("suma float: " + sumar(12.0f, 5f));
        System.out.println("suma float-int: " + sumar(4f, 5));
        System.out.println("suma int-float: " + sumar(5, 7f));
        System.out.println("suma float-float: " + sumar(3f,5f));
        System.out.println("suma double-oduble: " + sumar(4d,9d));
        System.out.println("suma string-string: "+ sumar("5", "6"));
        System.out.println("suma a + b + c: " + sumar(3,5,2));

        System.out.println("suma long: " + sumar(4l,6l));
    }
}
