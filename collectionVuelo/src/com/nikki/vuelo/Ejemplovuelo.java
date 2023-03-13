package com.nikki.vuelo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Ejemplovuelo {
    public static void main(String[] args) throws ParseException {
        List<Vuelo> listaVuelos =  new ArrayList<>();
        System.out.println("====================== Vuelos ======================");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        listaVuelos.add(new Vuelo("AAL 933", "New York", "Santiago", dateFormat.parse("2021-08-29 05:39"), 62));
        listaVuelos.add(new Vuelo("LAT 755", "Sao Paulo", "Santiago", dateFormat.parse("2021-08-31 04:45"), 47));
        listaVuelos.add(new Vuelo("SKU 621", "Rio De Janeiro", "Santiago", dateFormat.parse("2021-08-30 16:00"), 52));
        listaVuelos.add(new Vuelo("DAL 147", "Atlanta", "Santiago", dateFormat.parse("2021-08-29 13:22"), 59));
        listaVuelos.add(new Vuelo("AVA 241", "Bogota", "Santiago", dateFormat.parse("2021-08-31 14:05"), 25));
        listaVuelos.add(new Vuelo("AMX 10", "Mexico City", "Santiago", dateFormat.parse("2021-08-31 05:20"), 29));
        listaVuelos.add(new Vuelo("IBE 6833", "Londres", "Santiago", dateFormat.parse("2021-08-30 08:45"), 55));
        listaVuelos.add(new Vuelo("LAT 2479", "Frankfurt", "Santiago", dateFormat.parse("2021-08-29 07:41"), 51));
        listaVuelos.add(new Vuelo("SKU 803", "Lima", "Santiago", dateFormat.parse("2021-08-30 10:35"), 48));
        listaVuelos.add(new Vuelo("LAT 533", "Los Ángeles", "Santiago", dateFormat.parse("2021-08-29 09:14"), 59));
        listaVuelos.add(new Vuelo("LAT 1447", "Guayaquil", "Santiago", dateFormat.parse("2021-08-31 08:33"), 31));
        listaVuelos.add(new Vuelo("CMP 111", "Panama City", "Santiago", dateFormat.parse("2021-08-31 15:15"), 29));
        listaVuelos.add(new Vuelo("LAT 705", "Madrid", "Santiago", dateFormat.parse("2021-08-30 08:14"), 47));
        listaVuelos.add(new Vuelo("AAL 957", "Miami", "Santiago", dateFormat.parse("2021-08-29 22:53"), 60));
        listaVuelos.add(new Vuelo("ARG 5091", "Buenos Aires", "Santiago", dateFormat.parse("2021-08-31 09:57"), 32));
        listaVuelos.add(new Vuelo("LAT 1283", "Cancún", "Santiago", dateFormat.parse("2021-08-31 04:00"), 35));
        listaVuelos.add(new Vuelo("LAT 579", "Barcelona", "Santiago", dateFormat.parse("2021-08-29 07:45"), 61));
        listaVuelos.add(new Vuelo("AAL 945", "Dallas-Fort Worth", "Santiago", dateFormat.parse("2021-08-30 07:12"), 58));
        listaVuelos.add(new Vuelo("LAT 501", "París", "Santiago", dateFormat.parse("2021-08-29 18:29"), 49));
        listaVuelos.add(new Vuelo("LAT 405", "Montevideo", "Santiago", dateFormat.parse("2021-08-30 15:45"), 39));
        listaVuelos.sort((a, b) -> a.getFechaLlegada().compareTo(b.getFechaLlegada()));
        for( int i = 0; i<listaVuelos.size(); i++){
            Vuelo vuelo = listaVuelos.get(i);
            System.out.println(vuelo);
        }

        List<Vuelo> listaVuelospasajeros = new LinkedList<>();
        listaVuelospasajeros.addAll(listaVuelos);
        System.out.println();
        System.out.println();
        System.out.println("====================== VuelosPasajeros ======================");
        listaVuelospasajeros.sort((a, b) -> a.getCantidadPasajeros().compareTo(b.getCantidadPasajeros()));
        for(Vuelo pasajeros: listaVuelospasajeros){
            System.out.println(pasajeros);
        }


        System.out.println();
        System.out.println();
        System.out.println("=====================================================================================");
        Vuelo ultimo = listaVuelos.get(listaVuelos.size()-1);
        System.out.println("El último vuelo en llegar es " + ultimo.getNombre() +
                            " con destino a " + ultimo.getDestino() +
                            ", aterriza el " + ultimo.getFechaLlegada() );

        Vuelo pasajerosMenor = listaVuelospasajeros.get(0);
        System.out.println("El vuelo con menor número de pasajeros es " + pasajerosMenor.getNombre() +
                " con destino a " + pasajerosMenor.getDestino() +
                " , con " + pasajerosMenor.getCantidadPasajeros() + " pasajeros.");

    }
}
