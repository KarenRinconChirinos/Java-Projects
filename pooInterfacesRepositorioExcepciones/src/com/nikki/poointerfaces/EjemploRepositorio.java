package com.nikki.poointerfaces;

import com.nikki.poointerfaces.modelo.Cliente;
import com.nikki.poointerfaces.repositorio.*;
import com.nikki.poointerfaces.repositorio.excepciones.AccesoDatosException;
import com.nikki.poointerfaces.repositorio.excepciones.EscrituraAccesoDatoException;
import com.nikki.poointerfaces.repositorio.excepciones.LecturaAccessoDatoException;
import com.nikki.poointerfaces.repositorio.excepciones.RegistroDuplicadoAccesoDatoException;
import com.nikki.poointerfaces.repositorio.lista.ClienteListRepositorio;

import java.util.List;

public class EjemploRepositorio {
    public static void main(String[] args) {
        //ClienteListRepositorio como esta implementado con la interfaz
        //tipo mas generico, se utiliza el tipo crudRepositorio
        try {
            OrdenablePaginableCrudRepositorio<Cliente> repositorio = new ClienteListRepositorio();
            System.out.println("------------------- Interface crudRepositorio Crear ---------------------");
            Cliente kar = new Cliente("Karen", "Gogo");
            repositorio.crear(kar);
            repositorio.crear(new Cliente("Chirris", "Fam"));
            repositorio.crear(new Cliente("Luci", "Mar"));
            repositorio.crear(new Cliente("Francia", "Arma"));
            repositorio.crear(kar);

            //repositorio.crear(null);
            System.out.println("------------------- Interface crudRepositorio Listar ---------------------");
            List<Cliente> clientes = repositorio.listar();
            //clientes.forEach(c -> System.out.println(c)); //expresion lamda larga
            clientes.forEach(System.out::println); //expresion lamda corta

            System.out.println("------------------- Interface Paginable ---------------------");
            //se hace un cast en otra interface que e usa
            List<Cliente> paginable = repositorio.listar(0, 3);
            paginable.forEach(System.out::println);

            System.out.println("------------------- Interface Ordenable ---------------------");
            List<Cliente> ordenableAsc = repositorio.listar("nombre", Direccion.ASC);
            ordenableAsc.forEach(System.out::println);

            System.out.println("------------------- Interface Ordenable ---------------------");
            List<Cliente> ordenableDesc = ((OrdenableRepositorio) repositorio).listar("id", Direccion.DESC);
            ordenableDesc.forEach(System.out::println);

            System.out.println("------------------- Interface crudRepositorio Editar---------------------");
            Cliente actualizar = new Cliente("Karen", "Mena");
            actualizar.setId(2);
            repositorio.actualizar(actualizar);
            Cliente karen = (repositorio).buscarId(2);
            System.out.println(karen);

            System.out.println("------------------- Interface crudRepositorio Eliminar ---------------------");
            repositorio.eliminar(2);
            repositorio.listar().forEach(System.out::println);

            System.out.println("\n\n=========================");
            System.out.println("Total de registros: " + repositorio.total());

        }catch (RegistroDuplicadoAccesoDatoException rdae) {
            System.out.println("Escritura: " + rdae.getMessage());
            rdae.printStackTrace();
        }catch (LecturaAccessoDatoException lae){
            System.out.println("Lectura: " + lae.getMessage());
            lae.printStackTrace();
        }catch (EscrituraAccesoDatoException eade){
            System.out.println("Escritura: " + eade.getMessage());
            eade.printStackTrace();
        }catch (AccesoDatosException ade){
            System.out.println("Generica: " + ade);//el error de crear va caer aqui porque esta de forma general
            ade.printStackTrace();
        }
    }
}
