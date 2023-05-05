package com.nikki.optional.ejemplo;

import com.nikki.optional.ejemplo.models.Computador;
import com.nikki.optional.ejemplo.repositorio.ComputadorRepositorio;
import com.nikki.optional.ejemplo.repositorio.IRepositorio;

import java.util.Optional;

public class EjemploRepositorio {
    public static void main(String[] args) {
        IRepositorio<Computador> repo = new ComputadorRepositorio();
        //Computador defecto = new Computador("HP", "LA0001");
        Computador pc = repo.filtrar("Asusu").orElse(valorDefecto()); //sino se encuentra devuekve un objeto Computador
        //orElseThrow - sino lanza una exception, get se maneja en conjunto con el ispresent
        System.out.println(pc);

        pc = repo.filtrar("macbook").orElseGet(() -> {
            return valorDefecto();
        });
        System.out.println(pc);
    }

    public static Computador valorDefecto(){
        System.out.println("Obtenido valor por defecto!!!");
        return new Computador("HP Owen", "LA001");

    }
}
