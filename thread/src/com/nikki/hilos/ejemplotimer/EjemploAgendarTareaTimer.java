package com.nikki.hilos.ejemplotimer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class EjemploAgendarTareaTimer {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() { //finaliza el tiempo finaliza la tarea
                System.out.println("Tarea realizada en:" + new Date()
                + " Nombre del Thread: " + Thread.currentThread().getName());
                System.out.println("Finaliza el tiempo");
                timer.cancel();
            }
        }, 500 );
        System.out.println("Agendamos una tarea para 5 segundos mas");
    }
}
