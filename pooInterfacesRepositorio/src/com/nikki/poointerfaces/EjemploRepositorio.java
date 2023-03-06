package com.nikki.poointerfaces;

import com.nikki.poointerfaces.modelo.Cliente;
import com.nikki.poointerfaces.repositorio.*;

import java.util.List;

public class EjemploRepositorio {
    public static void main(String[] args) {
        //ClienteListRepositorio como esta implementado con la interfaz
        //tipo mas generico, se utiliza el tipo crudRepositorio

        OrdenablePaginableCrudRepositorio repositorio =  new ClienteListRepositorio();
        System.out.println("------------------- Interface crudRepositorio Crear ---------------------");
        repositorio.crear(new Cliente("Karen", "Gogo"));
        repositorio.crear(new Cliente("Chirris", "Fam"));
        repositorio.crear(new Cliente("Luci", "Mar"));
        repositorio.crear(new Cliente("Francia", "Arma"));

        System.out.println("------------------- Interface crudRepositorio Listar ---------------------");
        List<Cliente> clientes = repositorio.listar();
        //clientes.forEach(c -> System.out.println(c)); //expresion lamda larga
        clientes.forEach(System.out::println); //expresion lamda corta

        System.out.println("------------------- Interface Paginable ---------------------");
        //se hace un cast en otra interface que e usa
        List<Cliente> paginable = repositorio.listar(0,3);
        paginable.forEach(System.out::println);

        System.out.println("------------------- Interface Ordenable ---------------------");
        List<Cliente> ordenableAsc = repositorio.listar("nombre",Direccion.ASC);
        ordenableAsc.forEach(System.out::println);

        System.out.println("------------------- Interface Ordenable ---------------------");
        List<Cliente> ordenableDesc = ((OrdenableRepositorio)repositorio).listar("id",Direccion.DESC);
        ordenableDesc.forEach(System.out::println);

        System.out.println("------------------- Interface crudRepositorio Editar---------------------");
        Cliente actualizar = new Cliente("Karen", "Mena");
        actualizar.setId(2);
        repositorio.actualizar(actualizar);
        Cliente karen = (repositorio).buscarId(2);
        System.out.println(karen);

        System.out.println("------------------- Interface crudRepositorio Eliminar ---------------------");
        repositorio.eliminar(1);
        repositorio.listar().forEach(System.out::println);

        System.out.println("\n\n=========================");
        System.out.println("Total de registros: " + repositorio.total());
    }
}
