package com.nikki.datetime.ejemplos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class EjemploLocalDateTime {
    public static void main(String[] args) {
        LocalDateTime fechaTiempo = LocalDateTime.now();
        System.out.println("fechaTiempo = " + fechaTiempo);

        //fecha mas personalizada
        fechaTiempo = LocalDateTime.of(2020, Month.SEPTEMBER, 24, 11, 24,34);
        System.out.println("fechaTiempo = " + fechaTiempo);

        fechaTiempo = LocalDateTime.parse("2020-09-24T11:24:34");
        fechaTiempo = LocalDateTime.parse("2020-09-24T11:24:34.99");
        System.out.println("fechaTiempo = " + fechaTiempo);

        //podemos usar plus para sumar o minus para resta
        LocalDateTime  fechaTiempo2 = fechaTiempo.plusDays(1).plusHours(3);
        System.out.println("fechaTiempo2 = " + fechaTiempo2);
        System.out.println("fechaTiempo1 = " + fechaTiempo);
        System.out.println("fechaTiempo3 = " + fechaTiempo.minusHours(5));

        Month mes = fechaTiempo.getMonth();
        System.out.println("mes = " + mes);

        int dia = fechaTiempo.getDayOfMonth();
        System.out.println("dia = " + dia);

        int anio = fechaTiempo.getYear();
        System.out.println("anio = " + anio);

        //DateTimeFormatter - varios tipos de formatos
        /*
            ISO_DATE - solofecha
            ISO_DATE_TIME
         */
        String formato1 = fechaTiempo.format(DateTimeFormatter.ISO_DATE);
        System.out.println("formato1 = " + formato1);

        String formato2 = fechaTiempo.format(DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss a"));
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String formato3 = fechaTiempo.format(dateTimeFormatter);
        System.out.println("formato2 = " + formato3);

        String formato4 = dateTimeFormatter.format(fechaTiempo);
        System.out.println("formato4 = " + formato4);


    }
}
