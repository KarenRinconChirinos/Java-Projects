package com.nikki.hilos.ejemplotimer;

import java.awt.*;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class EjemploAgendarTareaTimerPeriodo {
    public static void main(String[] args) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Timer timer = new Timer();
        AtomicInteger  contador  = new AtomicInteger(3);
        timer.schedule(new TimerTask() {
            //private int contador = 3;
            @Override
            public void run() { //finaliza el tiempo finaliza la tarea
                int i = contador.getAndDecrement();
                if(i >  0) {
                    toolkit.beep();
                    System.out.println("Tarea " + i + " periodica en:" + new Date()
                            + " Nombre del Thread: " + Thread.currentThread().getName());
                    //contador--;
                }else{
                    System.out.println("Finaliza el tiempo");
                    timer.cancel();
                }
            }
        }, 0, 10000 );//delay, periodo
        System.out.println("Agendamos una tarea inmediata que se repite cada 10 segundos");
    }
}
