package com.nikki.datetime.ejemplos;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class EjemploDuration {
    public static void main(String[] args) {
        LocalDateTime fecha1 = LocalDateTime.now();
        fecha1.withMonth(3);//es inmutable
        LocalDateTime fecha2 = LocalDateTime.now().plusHours(1).plusMinutes(20).plusDays(1);
        Duration lapso = Duration.between(fecha1, fecha2);//con preciion
        System.out.println("lapso: " + lapso);
        System.out.println("lapso seconds: " + lapso.getSeconds());
        System.out.println("lapso days: " + lapso.toDays());
        System.out.println("lapso + 5 horas: " + lapso.plusHours(5));




    }
}
