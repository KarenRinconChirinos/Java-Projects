package com.nikki.hilos.ejemploexecutor;

import com.nikki.hilos.ejemplosync.Panaderia;
import com.nikki.hilos.ejemplosync.runnable.Consumidor;
import com.nikki.hilos.ejemplosync.runnable.Panadero;

import java.util.concurrent.*;

public class EjemploExecutorProductorConsumidor {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2); //tañamo de pool minimo de 2
        System.out.println("tamaño del pool - " +  executor.getPoolSize()); //tamño actual
        System.out.println("cantidad de tareas en cola- " + executor.getQueue().size());

        Panaderia p = new Panaderia();//monitor o recurso compartido
        Runnable productor = new Panadero(p);
        Runnable consumidor = new Consumidor(p);
        Future<?> futuro1 = executor.submit(productor);
        Future<?> futuro2 = executor.submit(consumidor);

        System.out.println("tamaño del pool - " +  executor.getPoolSize()); //tamño actual
        System.out.println("cantidad de tareas en cola- " + executor.getQueue().size());

        executor.shutdown();
        System.out.println("Continuado con la ejecucion de metodo main 1");
    }
}
