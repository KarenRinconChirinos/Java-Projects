package com.nikki.hilos.ejemploexecutor;

import com.sun.jdi.event.ExceptionEvent;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class EjemploExecutor {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        //Execute - > solo ejecuta una tarea
        //si el pool es de 5 y 10 tareas, deja 5 y las otras en cola
        //Executo service -> hacer un seguimiento de la tarea,

        Runnable tarea = ()->{
            System.out.println("Inicio de la tarea...");
            try {
                System.out.println("Nombre del thread" + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(1); //duerme el hilo actual
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
            System.out.println("Finaliza la tarea");
        };

        executor.submit(tarea);// enviar tarea
        executor.shutdown();//cierra una vez que terina la ejecucuion de todas las tareas tanto en cola y ejecucion
        //shutdowNowterminar de forma abrupta tareas a medio camino
        System.out.println("Continuado con la ejecucion de metodo main 1");
        executor.awaitTermination(2, TimeUnit.SECONDS);// esperar aque finalicen las tareas y que se ejecute el executor
        System.out.println("Continuado con la ejecucion de metodo main 2");

    }
}
