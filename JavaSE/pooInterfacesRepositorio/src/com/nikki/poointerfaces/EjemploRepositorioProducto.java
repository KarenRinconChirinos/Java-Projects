package com.nikki.poointerfaces;

import com.nikki.poointerfaces.modelo.Cliente;
import com.nikki.poointerfaces.modelo.Producto;
import com.nikki.poointerfaces.repositorio.Direccion;
import com.nikki.poointerfaces.repositorio.OrdenablePaginableCrudRepositorio;
import com.nikki.poointerfaces.repositorio.OrdenableRepositorio;
import com.nikki.poointerfaces.repositorio.lista.ClienteListRepositorio;
import com.nikki.poointerfaces.repositorio.lista.ProductoListRepositorio;

import java.util.List;

public class EjemploRepositorioProducto {
    public static void main(String[] args) {
        //ClienteListRepositorio como esta implementado con la interfaz
        //tipo mas generico, se utiliza el tipo crudRepositorio

        OrdenablePaginableCrudRepositorio<Producto> repositorio =  new ProductoListRepositorio();
        System.out.println("------------------- Interface crudRepositorio Crear ---------------------");
        repositorio.crear(new Producto("Mesa", 100d));
        repositorio.crear(new Producto("Silla", 50.3));
        repositorio.crear(new Producto("Lampara",490.7 ));
        repositorio.crear(new Producto("Caja",12d ));

        System.out.println("------------------- Interface crudRepositorio Listar ---------------------");
        List<Producto> productos = repositorio.listar();
        //clientes.forEach(c -> System.out.println(c)); //expresion lamda larga
        productos.forEach(System.out::println); //expresion lamda corta

        System.out.println("------------------- Interface Paginable ---------------------");
        //se hace un cast en otra interface que e usa
        List<Producto> paginable = repositorio.listar(0,3);
        paginable.forEach(System.out::println);

        System.out.println("------------------- Interface Ordenable ---------------------");
        List<Producto> ordenableAsc = repositorio.listar("precio",Direccion.ASC);
        ordenableAsc.forEach(System.out::println);

        System.out.println("------------------- Interface Ordenable ---------------------");
        List<Producto> ordenableDesc = ((OrdenableRepositorio)repositorio).listar("id",Direccion.DESC);
        ordenableDesc.forEach(System.out::println);

        System.out.println("------------------- Interface crudRepositorio Editar---------------------");
        Producto actualizar = new Producto("Mesa", 16667.8);
        actualizar.setId(1);
        repositorio.actualizar(actualizar);
        Producto karen = (repositorio).buscarId(2);
        System.out.println(karen);

        System.out.println("------------------- Interface crudRepositorio Eliminar ---------------------");
        repositorio.eliminar(1);
        repositorio.listar().forEach(System.out::println);

        System.out.println("\n\n=========================");
        System.out.println("Total de registros: " + repositorio.total());
    }
}
