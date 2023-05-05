package com.nikki.hilos.ejemploexecutor;

import java.util.concurrent.*;

public class EjemploExecutorFuture2 {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
        System.out.println("tamaño del pool - " +  executor.getPoolSize()); //tamño actual
        System.out.println("cantidad de tareas en cola- " + executor.getQueue().size());
        Callable<String> tarea = ()->{
            System.out.println("Inicio de la tarea...");
            try {
                System.out.println("Nombre del thread" + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(3); //duerme el hilo actual
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
            System.out.println("Finaliza la tarea");
            return "Algun resultado impo de la tarea ";
         };
        Callable<Integer> tarea2 = ()->{
            System.out.println("Iniciando tarea 2...");
            TimeUnit.SECONDS.sleep(3);
            return 10;
        };
        Future<String> resultadoFuturo = executor.submit(tarea);// el submit cuando enviamos una tarea d ejecucuion, acepta un runnable o un callble
        Future<String> resultadoFuturoo2 = executor.submit(tarea);
        Future<Integer> resultadoFuturo3 = executor.submit(tarea2);
        System.out.println("tamaño del pool - " +  executor.getPoolSize()); //tamño actual
        System.out.println("cantidad de tareas en cola- " + executor.getQueue().size());

        executor.shutdown();
        System.out.println("Continuado con la ejecucion de metodo main 1");
        while(!(resultadoFuturo.isDone() &&
                resultadoFuturoo2.isDone() &&
                resultadoFuturo3.isDone())){ //mientras no finalicen estas 3 tareas
            System.out.println(String.format("resultado1: %s - resultado2: %s - resultado3,: %s",
                    resultadoFuturo.isDone()?"finalizo":"en proceso",
                    resultadoFuturoo2.isDone()?"finalizo":"en proceso",
                    resultadoFuturo3.isDone()?"finalizo":"en proceso")); //cada una demora 3 seg
            TimeUnit.MILLISECONDS.sleep(1000); //se imprime entre cuando se ejecuta la tarea
        }//se tiene que ejecutar de auno por que el pool es de 1 solo
        System.out.println("Obtenemos resutlado de la tarea "+ resultadoFuturo.get(5,TimeUnit.SECONDS)); //el metodo get no es bueno llmarlo ya que bloque el thread actual y queda en espera hadta ue finalice y devuelva el valor
        System.out.println("Finaliza la tarea " + resultadoFuturo.isDone());

        System.out.println("Obtenemos resutlado de la tarea "+ resultadoFuturoo2.get(5,TimeUnit.SECONDS)); //el metodo get no es bueno llmarlo ya que bloque el thread actual y queda en espera hadta ue finalice y devuelva el valor
        System.out.println("Finaliza la tarea " + resultadoFuturo.isDone());

        System.out.println("Obtenemos resutlado de la tarea "+ resultadoFuturo3.get(5,TimeUnit.SECONDS)); //el metodo get no es bueno llmarlo ya que bloque el thread actual y queda en espera hadta ue finalice y devuelva el valor
        System.out.println("Finaliza la tarea " + resultadoFuturo.isDone());


    }
}
