package com.nikki.datetime.ejemplos;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class EjemploLocalDate {
    public static void main(String[] args) {
        LocalDate fechaActual = LocalDate.now();
        System.out.println("fechaActual = " + fechaActual);
        System.out.println("Dia: " + fechaActual.getDayOfMonth());
        System.out.println("Mes: " + fechaActual.getMonth());

        Month mes = fechaActual.getMonth();
        System.out.println("Mes english: " + mes);
        System.out.println("mes.getValue() (numero del mes) = " + mes.getValue());
        System.out.println("mes español: " + mes.getDisplayName(TextStyle.FULL, new Locale("es", "ES")));

        DayOfWeek diaSemana = fechaActual.getDayOfWeek();
        System.out.println("Numero del dia: " + diaSemana.getValue());
        System.out.println("Nombre del dia español " + diaSemana.getDisplayName(TextStyle.FULL, new Locale("es", "ES")));

        System.out.println("Año: " + fechaActual.getYear());
        System.out.println("Dia del año: " + fechaActual.getDayOfYear());
        System.out.println("Era: " + fechaActual.getEra());
        
        
        fechaActual = LocalDate.of(2020, 2, 25);
        System.out.println("fechaActual = " + fechaActual);

        fechaActual = LocalDate.of(2021, Month.APRIL, 26);
        System.out.println("fechaActual = " + fechaActual);

        fechaActual = LocalDate.parse("2020-01-02");
        System.out.println("fechaActual = " + fechaActual);

        //con plus sumamos dias //minus para restar dias
        LocalDate diaMañana = LocalDate.now().plusDays(1);
        System.out.println("diaMañana = " + diaMañana);

        LocalDate mesAnteriorMismoDia = LocalDate.now().minusMonths(1);
        System.out.println("mesAnteriorMismoDia = " + mesAnteriorMismoDia);

        //es lo mismo que minus
        mesAnteriorMismoDia = LocalDate.now().minus(1, ChronoUnit.MONTHS);
        System.out.println("mesAnteriorMismoDia = " + mesAnteriorMismoDia);
        DayOfWeek miercoles = LocalDate.parse("2020-11-11").getDayOfWeek();
        System.out.println("miercoles = " + miercoles);

        int once = LocalDate.of(2020, 11,11).getDayOfMonth();
        System.out.println("once = " + once);

        //como saber si es bisiensto o no el año
        boolean esBisiesto = LocalDate.now().isLeapYear();
        System.out.println("esBisiesto = " + esBisiesto);

        //comparar fechas
        boolean esAntes = LocalDate.of(2020, Month.SEPTEMBER,25).isBefore(LocalDate.parse("2020-04-23"));
        System.out.println("esAntes = " + esAntes);

        boolean esDespues = LocalDate.parse("2020-10-23").isBefore(LocalDate.now());
        System.out.println("esDespues = " + esDespues);

        esDespues = LocalDate.now().isAfter(LocalDate.now().minus(1,ChronoUnit.DAYS));
        System.out.println("esDespues = " + esDespues);


    }

}
