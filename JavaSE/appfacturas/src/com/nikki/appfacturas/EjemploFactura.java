package com.nikki.appfacturas;

import com.nikki.appfacturas.modelo.*;

import java.util.Scanner;

public class EjemploFactura {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.setNombre("Karen");
        cliente.setNumFiscal("111111");

        Scanner scanner = new Scanner(System.in);
        System.out.println("ingrese la descripcion de la factura");
        Factura factura = new Factura(scanner.nextLine(), cliente);

        Producto producto;
        for(int i = 0; i<2; i++){
            producto = new Producto();
            System.out.print("Ingrese el producto N°" + producto.getCodigo() + ": ");
            producto.setNombre(scanner.nextLine());

            System.out.print("Ingresa el precio: ");
            producto.setPrecio(scanner.nextFloat());

            System.out.print("Ingresa la cantidad: ");

            factura.addItemFactura(new ItemFactura(scanner.nextInt(), producto));
            System.out.println();
            scanner.nextLine();
        }
        System.out.println(factura.toString());// por debajo tiene el toString que invoca el generarfactura
    }
}
