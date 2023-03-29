package com.nikki.optional.ejemplo;

import com.nikki.optional.ejemplo.models.Computador;
import com.nikki.optional.ejemplo.repositorio.ComputadorRepositorio;
import com.nikki.optional.ejemplo.repositorio.IRepositorio;

import java.util.Optional;

public class EjemploRepositorio {
    public static void main(String[] args) {
        IRepositorio<Computador> repo = new ComputadorRepositorio();
        repo.filtrar("Asusu").ifPresentOrElse(System.out::println, () -> System.out.println("No se encontro"));
        /*Optional<Computador> pc = repo.filtrar("Asusu");
        if(pc.isPresent()){
            System.out.println(pc.get().toString());
        }else{
            System.out.println("No se encontro");
        }*/
    }
}
