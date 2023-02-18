package com.nikki.calculadora;

public class Calculadora {

    private Calculadora(){// se restringe que se pueda crear instancias

    }

    public static int sumar(int a, int b){
        return a + b;
    }

    public static int sumar(int... argumentos){ // es del tipo arreglo
        int total = 0;
        for(int i=0; i<argumentos.length; i++){
            total += argumentos[i];
        }
        return total;
    }

    public static float sumar(float... argumentos){ // es del tipo arreglo
        float total = 0;
        for(int i=0; i<argumentos.length; i++){
            total += argumentos[i];
        }
        return total;
    }

    public static double sumar(double... argumentos){ // es del tipo arreglo
        double total = 0;
        for(int i=0; i<argumentos.length; i++){
            total += argumentos[i];
        }
        return total;
    }

    public static float sumar(float a , float b){
        return a + b;
    }

    public static float sumar(int a , float b){
        return a + b;
    }

    public static float sumar(float a , int b){
        return a + b;
    }

    public static double sumar(double a, double b){
        return a + b;
    }

    public static int sumar(String a, String b){
        int res;
        try{
            res = Integer.parseInt(a) + Integer.parseInt(b);

        }catch (NumberFormatException e){
            res = 0;
        }
        return res;
    }

    public static int sumar (int a, int b, int c){
        return a + b + c;
    }

}
