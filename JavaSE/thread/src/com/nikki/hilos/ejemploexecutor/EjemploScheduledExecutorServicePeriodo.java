package com.nikki.hilos.ejemploexecutor;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class EjemploScheduledExecutorServicePeriodo {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        System.out.println("Alguna tarea en el main...");
        AtomicInteger contador = new AtomicInteger(5);
        //CountDownLatch lock = new CountDownLatch(5); //opera de fomra concurrente
        Future<?> future = executorService.scheduleAtFixedRate(() ->{
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
                //lock.countDown();
                contador.getAndDecrement();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hola mundo tarea... ");
        },1000 , 2000, TimeUnit.MILLISECONDS);
        //pausa de un segundo por lo que realiza 5 ejecucuiones
        //lock.await();
        //future.cancel(true);
        //TimeUnit.SECONDS.sleep(10);
        while (contador.get() >= 0){
            if(contador.get() == 0){
                future.cancel(true);
                contador.getAndDecrement();
            }
        }
        System.out.println("Alguna otra tarea en el main...");
        executorService.shutdown();
    }
}
