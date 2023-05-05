package com.nikki.datetime.ejemplos;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Set;

public class EjemploZonedDateTime {
    public static void main(String[] args) {
        LocalDateTime fechaLocal = LocalDateTime.parse("2021-09-23T12:45",
                DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));
        ZoneId newYork = ZoneId.of("America/New_York");
        ZonedDateTime zonaNewYork = ZonedDateTime.of(fechaLocal, newYork);
        zonaNewYork = fechaLocal.atZone(newYork);

        System.out.println("Horario de partida de NewYork = " + zonaNewYork);


        
        ZoneId madrid = ZoneId.of("Europe/Madrid");
        ZonedDateTime zonMadrid = zonaNewYork.withZoneSameInstant(madrid).plus(8, ChronoUnit.HOURS);
        System.out.println("Hora de llegada a Madrid = " + zonMadrid);

        madrid = ZoneId.of("Europe/Madrid");


        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm, ddMMM yyyy");
        System.out.println("Partida NewYork = " + dateTimeFormatter.format(zonaNewYork));
        System.out.println("Lelgada Madrid: " + dateTimeFormatter.format(zonMadrid));

        //TODAS LAS zonas id 
        Set<String> zonas = ZoneId.getAvailableZoneIds();
        zonas.forEach(System.out::println);
    }
}
