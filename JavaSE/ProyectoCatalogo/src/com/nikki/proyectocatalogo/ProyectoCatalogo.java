package com.nikki.proyectocatalogo;

import com.nikki.proyectocatalogo.productos.*;

import java.util.Calendar;
import java.util.Date;

public class ProyectoCatalogo {
    public static void main(String[] args) {
        IProducto[] productos = new Productos[7];
        productos[0] = new Libro(560, new Date(2012, Calendar.MARCH,23),"Victor Hugo","Los miserables", "Omega");
        productos[1] = new Libro(453, new Date(2019, Calendar.MARCH,20),"Victor Hugo","Los miserables", "Editorial Mango");
        productos[2] = new TvLcd(25000, "LG", 60);
        productos[3] = new IPhone(22000, "Apple", Color.BLANCO, "");
        productos[4] = new Comics(100, new Date(2000, Calendar.MAY, 29),"Echirio Oda", "One Piece","Panini","Luffy");
        productos[5] = new Comics(85, new Date(1999, Calendar.MAY, 29),"Naoko Takeuchi", "Sailor Moon","Panini","Sailor Moon");
        imprimir(productos);
    }

    public static void imprimir(IProducto[] productos){
        for(IProducto produc : productos){
            System.out.println();
            System.out.println();
            if(produc instanceof ILibro && produc instanceof Comics){
                System.out.println("Fecha de publicacion: " + ((Comics) produc).getFechaPublicacion());
                System.out.println("Autor: " + ((Comics) produc).getAutor());
                System.out.println("Titulo: " + ((Comics) produc).getTitulo());
                System.out.println("Editorial: " + ((Comics) produc).getEditorial());
                System.out.println("Personaje: " + ((Comics) produc).getPersonaje());
                System.out.println("Precio: " + ((Comics) produc).getPrecioVenta());


            }else if(produc instanceof ILibro) {
                System.out.println("Fecha de publicacion: " + ((Libro) produc).getFechaPublicacion());
                System.out.println("Autor: " + ((Libro) produc).getAutor());
                System.out.println("Titulo: " + ((Libro) produc).getTitulo());
                System.out.println("Editorial: " + ((Libro) produc).getEditorial());
                System.out.println("Precio: " + ((Libro) produc).getPrecioVenta());

            }else if(produc instanceof IElectronico && produc instanceof IPhone){
                System.out.println("Fabricante: " + ((IPhone) produc).getFabricante());
                System.out.println("Modelo: " + ((IPhone) produc).getModelo());
                System.out.println("Color: " + ((IPhone) produc).getColor());
                System.out.println("Precio: " + ((IPhone) produc).getPrecioVenta());

            }else if(produc instanceof IElectronico && produc instanceof TvLcd){
                System.out.println("Fabricante: " + ((TvLcd) produc).getFabricante());
                System.out.println("Pulgada: " + ((TvLcd) produc).getPulgada());
                System.out.println("Precio: " + ((TvLcd) produc).getPrecioVenta());
            }
        }
    }
}
