package com.nikki.hilos.ejemploexecutor;

import java.util.concurrent.*;

public class EjemploExecutorFuture {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        //Execute - > solo ejecuta una tarea
        //si el pool es de 5 y 10 tareas, deja 5 y las otras en cola
        //Executo service -> hacer un seguimiento de la tarea,


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

        //vuelve a este objeto una representacion futura de la tarea, es del tipo string ya
        //se esta devolviendo una tarea
        Future<String> resultadoFuturo = executor.submit(tarea);// el submit cuando enviamos una tarea d ejecucuion, acepta un runnable o un callble
        executor.shutdown();
        System.out.println("Continuado con la ejecucion de metodo main 1");
        //System.out.println(resultadoFuturo.isDone()); //resutlado futuro que retorna la tarea


        while(!resultadoFuturo.isDone()){
            System.out.println("ejecuntando tarea...");
            TimeUnit.MILLISECONDS.sleep(1500); //se imprime entre cuando se ejecuta la tarea
        }
        System.out.println("Obtenemos resutlado de la tarea "+ resultadoFuturo.get(5,TimeUnit.SECONDS)); //el metodo get no es bueno llmarlo ya que bloque el thread actual y queda en espera hadta ue finalice y devuelva el valor
        System.out.println("Finalza la tarea " + resultadoFuturo.isDone());
        //le dimos mas tiempo al timeout, si le damos menos manda un error
        //con el get se bloquea durante 3 segundos y no devuelve nada null
    }
}
