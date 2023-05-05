package com.nikki.ejemplo;

import com.nikki.almacenverduleria.*;

public class EjemploAlmacenVerduleria {
    public static void main(String[] args) {
        Producto[] productos =  new Producto[8];

        productos[0] =  new Lacteo(1, 355, "Bola Queso panela",97.50d);
        productos[1] =  new Lacteo(3, 1500, "Queso oaxaca",97.50d);

        productos[2] =  new Fruta("Manzana", 35.50d, 3d,"Roja");
        productos[3] =  new Fruta("Fresa", 70d, 1d,"Roja");

        productos[4] =  new Limpieza("Salvo liquido", 35.50d, "Limon",1.5);
        productos[5] =  new Limpieza("Fabuloso lavanda", 20d, "Lavanda",2d);

        productos[6] =  new NoPerecible("Aceite nutrioli", 35.50d, 1,5000);
        productos[7] =  new NoPerecible("Arroz SOS", 30d , 1 ,5000);


        for (Producto produc: productos){
            System.out.println("-----------------" + produc.getClass().getName() + "-----------------");
            System.out.print("Nombre: " + produc.getNombre());
            System.out.println("Precio: " + produc.getPrecio());
            if (produc instanceof Lacteo){
                System.out.print("Cantidad: " + ((Lacteo) produc).getCantidad());
                System.out.print("Proteinas: " + ((Lacteo) produc).getProteinas());
            }else if (produc instanceof  Fruta){
                System.out.print("Peso: " + ((Fruta) produc).getPeso());
                System.out.print("Color: " + ((Fruta) produc).getColor());
            }else if (produc instanceof Limpieza){
                System.out.print("Componentes: " + ((Limpieza) produc).getComponentes());
                System.out.print("Litros: " + ((Limpieza) produc).getLitros());
            }else if (produc instanceof NoPerecible){
                System.out.print("Contenido: " + ((NoPerecible) produc).getContenido());
                System.out.print("Calorias: " + ((NoPerecible) produc).getCalorias());
            }
            System.out.println("\n\n");
        }
    }
}
