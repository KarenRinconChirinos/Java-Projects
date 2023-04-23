package com.nikki.patrones.singleton;

public class EjemploSingleton {
    public static void main(String[] args) {
        ConexionBDSingleton con = null;
        for(int i = 0; i <10; i++){
            con = ConexionBDSingleton.getInstance();
            System.out.println("con. = " + con);
        }
        ConexionBDSingleton con1 = ConexionBDSingleton.getInstance();
        ConexionBDSingleton con2 = ConexionBDSingleton.getInstance();
        boolean b1 = ((con == con2) && (con == con1));
        System.out.println("b1 = " + b1);
    }

}
