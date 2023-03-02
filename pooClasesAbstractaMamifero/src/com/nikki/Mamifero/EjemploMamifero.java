package com.nikki.Mamifero;

import com.nikki.Mamifero.Canino.Lobo;
import com.nikki.Mamifero.Canino.Perro;
import com.nikki.Mamifero.Felino.Guepardo;
import com.nikki.Mamifero.Felino.Leon;
import com.nikki.Mamifero.Felino.Tigre;

public class EjemploMamifero {
    public static void main(String[] args) {
        Mamifero[] mamiferos =  new Mamifero[6];
        mamiferos[0] =  new Leon("Zoologico de Chapultepec", 3f,4f, 280d, "Panthera leo", 50d, 59, 20,1.d);
        mamiferos[1] =  new Tigre("Zoologico de Chapultepec", 3.2f,3.5f, 200d, "Panthera tigris ", 50d, 59, "bengala");
        mamiferos[2] =  new Guepardo("Zoologico de Chapultepec", 3f,4f, 280d, "Guepardo", 50d, 59);
        mamiferos[3] =  new Perro("Zoologico de Chapultepec", .30f,.50f, 5d, "Firulais", "Blanco",0.5d,1);
        mamiferos[4] =  new Perro("Zoologico de Chapultepec", .40f,.60f, 15d, "Firulais", "Cafe",0.5d,2 );
        mamiferos[5] =  new Lobo("Zoologico de Chapultepec", 2f,2f, 150d, "Lobius", "Gris",5d,5, "Lobo mexicano");

        for(Mamifero m: mamiferos){
            System.out.println("------------------------------------- " + m.getClass().getSimpleName() + " -------------------------------------------");
            if ( m instanceof Lobo){
                System.out.println("Numero de camada: " + ((Lobo) m).getNumeroCamada());
                System.out.println("Especie: " + ((Lobo) m).getEspecie());
            }else if(m  instanceof  Perro){
                System.out.println("Fuerza mordida: " + ((Perro) m).getFuerzaMordida());
                System.out.println("Tamaño colmillos: " + ((Perro) m).getTamañoColmillos());
            }else if(m instanceof Tigre){
                System.out.println("Especie: " +((Tigre) m).getEspecie());
            }else if(m instanceof Leon){
                System.out.println("Numero manada: " + ((Leon) m).getNumeroManada());
                System.out.println("Potencia Rugido: " + ((Leon) m).getPotenciaRugido());
            }
            System.out.println(m.comer());
            System.out.println(m.comunicarse());
            System.out.println(m.correr());
            System.out.println(m.dormir());
            System.out.println();
        }
    }
}
