package com.nikki.api.stream.ejeplo;

import com.nikki.api.stream.ejeplo.Models.Producto;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EjemploStreamCalcularImporetProductoListaSumarlo {
    public static void main(String[] args) {
        /*El siguiente requerimiento es para una lista de productos
        *  List<Producto> , de 3 a 5 elementos, se pide calcular el
        * importe (precio por cantidad) y sumarlos.

        La clase Producto debe tener el atributo precio del tipo double
        * y cantidad int, entonces utilizando stream convertir la lista
        * de productos en el gran total del tipo double.*/
        List<Producto> listaProducto = new ArrayList<>();
        listaProducto.add(new Producto("Maruchan", 15.0, 2));
        listaProducto.add(new Producto("Leche", 20.0, 1));
        listaProducto.add(new Producto("Paleta", 3.0, 1));
        listaProducto.add(new Producto("Refresco", 15.0, 2));
        double s = listaProducto.stream()
                .mapToDouble(a -> a.getPrecio() * a.getCantidad())
                .sum();
        System.out.println(s);
    }
}
