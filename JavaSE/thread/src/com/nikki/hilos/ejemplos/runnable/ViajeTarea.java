package com.nikki.hilos.ejemplos.runnable;

public class ViajeTarea implements Runnable {
    private String nombre;

    public ViajeTarea(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            System.out.println( i + " = " + nombre);
            try {
                Thread.sleep((long)Math.random() * 1000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Finalmente e voy de viaje a: " + nombre);
    }
}
