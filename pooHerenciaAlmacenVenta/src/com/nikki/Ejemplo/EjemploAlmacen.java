package com.nikki.Ejemplo;

import com.nikki.AlmacenVentas.*;

import java.util.Calendar;
import java.util.Date;

public class EjemploAlmacen {
    public static void main(String[] args) {
        /*Un almacén de venta por mayor vende productos alimenticios perecederos
         y no perecederos y artículos de limpieza. Tiene dos vendedores. Desarrollar
         un diagrama de clases que modele esta situación teniendo en cuenta a sus clientes.
         Ademas escriba con código java la jerarquía de clases que están presentes.*/

        Productos[] productos = new Productos[6];
        productos[0] = new Perecederos("Refrigeradores", "Fresas", 100, "Fresa mexicana del puertos de san joaquin", 50d, new Date(2023, Calendar.MARCH,2), 1.5d, "roja");
        productos[1] = new Perecederos("Refrigeradores", "Mango", 100, "Mnago de tierras mexicanas de los huertos de oaxaca", 50d, new Date(2023, Calendar.MARCH,2), 1.5d, "amarillo");
        productos[2] = new NoPerecederos("Piso 2 Pasillo 3", "Atun en agua", 500, "Atun enlatado", 30d, new Date(2025, Calendar.SEPTEMBER,25), 1, 500);
        productos[3] = new NoPerecederos("Piso 2 Pasillo 3", "Frijol negro", 200, "Frijol negro criollo", 45d, new Date(2025, Calendar.SEPTEMBER,25), 1, 456);
        productos[4] = new ArticulosLimpieza("Piso 1 Pasillo 1", "Fabuloso", 300, "Detergente liquido para pisos", 35d, 1d, "Jabon ...");
        productos[5] = new ArticulosLimpieza("Piso 1 Pasillo 1", "Salvo en polvo", 500, "Jabon en polvo para trastes", 28.5d, 1d, " Jabon ...");

        Persona[] personas = new Persona[4];
        personas[0] = new Empleado("Alfonso" , 31, "ADJD 34", "Refrigeracion", 20000);
        personas[1] = new Empleado("Mario", 34, "SLSD 23", "Piso 1",  15000);
        personas[2] = new Cliente("Liz", 44,55432312);
        personas[3] = new Cliente("Jaime", 23,55432312);

        Carrito[] carrito = {
                new Carrito(productos[0] , personas[2], 5),
                new Carrito(productos[3] , personas[2], 10),
                new Carrito(productos[5] , personas[2], 2),
                new Carrito(productos[2] , personas[2], 12)

        };
        Carrito[] carrito2 = new Carrito[1];
        carrito2[0] =  new Carrito( productos[0] , personas[3], 5);


        System.out.println("---------------------------------------- Lista de productos --------------------------------------------");
        imprimirProductos(productos);
        System.out.println("\n\n");
        System.out.println("---------------------------------------- Lista de ventas --------------------------------------------");
        imprimirListadeClientes(carrito);
        imprimirListadeClientes(carrito2);
    }

    private static void imprimirProductos(Productos[] productos){
        for (int i = 0; i<productos.length; i++){
            System.out.println("-------------------- " + productos[i].getClass().getSimpleName() + " --------------------" );
            System.out.println(productos[i].getNombre());
            if(productos[i] instanceof Perecederos){
                System.out.println("Se encuentran en el " + productos[i].getLugar());
            }else if(productos[i] instanceof NoPerecederos){
                System.out.println("Se encuentran en el " + productos[i].getLugar());
            }else if(productos[i] instanceof ArticulosLimpieza){
                System.out.println("Se encuentran en el " + productos[i].getLugar());
            }
        }
    }

    private static void imprimirListadeClientes(Carrito[] carrito){
        for (int i = 0; i<carrito.length; i++){
            System.out.println("---------------------------------------- Lista de productos del Cliente " + carrito[i].getPersona().getNombre() + "--------------------------------------------");
            System.out.println("Producto: " + carrito[i].getProductos().getNombre() + " cant: " + carrito[i].getCantidad());

        }
    }
}
