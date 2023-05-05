package com.nikki.hilos.ejemplos;

import com.nikki.hilos.ejemplos.runnable.ViajeTarea;

public class EjemploInterfaceRunnableJava8 {
    public static void main(String[] args) throws InterruptedException {
        Thread main = Thread.currentThread();
        //Clase anonima
        Runnable viaje1 = new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 10; i++){
                    System.out.println( i + " = " + Thread.currentThread().getName());
                    try {
                        Thread.sleep((long)Math.random() * 1000l);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Finalmente e voy de viaje a: " + Thread.currentThread().getName());
            }
        };

        //expresiones lambda
        Runnable viaje = ()->{ //sin argumentos
                for(int i = 0; i < 10; i++){
                    System.out.println( i + " = " + Thread.currentThread().getName());
                    try {
                        Thread.sleep((long)Math.random() * 1000l);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Finalmente e voy de viaje a: " + Thread.currentThread().getName());
        };


        //constructor nos permite pasar una instancia de runnable y ademas el nombre del thread
        Thread v1 = new Thread(viaje, ("Isla mujeres"));
        Thread v2 = new Thread(viaje, ("Acapulco"));
        Thread v3 = new Thread(viaje, ("Puebla"));
        Thread v4 = new Thread(viaje, ("Veracurz"));
        Thread v5 = new Thread(viaje, ("Isla canarios"));
        //cada hilo va tener su propia secuencia en un punto
        // determinado de la aplicacion y em paralelo
        v1.start();
        v2.start();
        v3.start();
        v4.start();
        v5.start();
        v1.join();//uniendo el thread principal con el de viaje1
        v2.join();
        v3.join();
        v4.join();
        v5.join();
        //Thread.sleep(1000);
        System.out.println("Continuando con la ejecucion del metodo main" + main.getName());
        System.out.println("MAIN: " + main.getState());

    }
}
