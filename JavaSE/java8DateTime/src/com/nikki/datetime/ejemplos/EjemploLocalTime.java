package com.nikki.datetime.ejemplos;


import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class EjemploLocalTime {
    public static void main(String[] args) {
        LocalTime ahora = LocalTime.now();
        System.out.println("ahora = " + ahora);
        System.out.println("Hora = " + ahora.getHour());
        System.out.println("Segundo= " + ahora.getSecond());
        System.out.println("Nanoseg = " + ahora.getNano());

        //formato horas, minutos
        LocalTime seisContTreinta = LocalTime.of(6,30,59);
        System.out.println("seisContTreinta = " + seisContTreinta);
        seisContTreinta = LocalTime.parse("06:30");//am
        seisContTreinta = LocalTime.parse("18:30"); //pm

        //agrega mints, horas seg con plus o diminuye con minus
        LocalTime sieteConTreinta = LocalTime.of(6,30).plus(1, ChronoUnit.HOURS);
        System.out.println("sieteConTreinta = " + sieteConTreinta);

        boolean esAnterior = LocalTime.of(6,30).isBefore(LocalTime.parse("07:30"));
        System.out.println("esAnterior = " + esAnterior);

        //tener un formato debe ser en minuscula los minutos (mayusucla es para mes)
        //HH -> formato 24 horas
        //hh -> formato am/pm
        // a / p indica am/pm
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
        String horaFormateado = seisContTreinta.format(dateTimeFormatter);
        System.out.println("horaFormateado = " + horaFormateado);

        horaFormateado = dateTimeFormatter.format(ahora);
        System.out.println("horaFormateado = " + horaFormateado);

        //hora maxima y hora minima de un dia
        LocalTime max = LocalTime.MAX;
        LocalTime min = LocalTime.MIN;

        System.out.println("min = " + min);
        System.out.println("max = " + max);



    }

}
