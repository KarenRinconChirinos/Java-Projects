package com.nikki.patrones.singleton;

public class ConexionBDSingleton {
    private static ConexionBDSingleton instancia;


    private ConexionBDSingleton (){ //evitar crear instancias, por eso el private en ele constuctor
        System.out.println("Conectando algun motor de base de datos");

    }

    public static ConexionBDSingleton getInstance(){
        if(!(instancia instanceof  ConexionBDSingleton)){
            instancia = new ConexionBDSingleton();
        }
        return instancia;
    }
}
