package com.nikki.optional.ejemplo;

import com.nikki.optional.ejemplo.models.Computador;
import com.nikki.optional.ejemplo.repositorio.ComputadorRepositorio;
import com.nikki.optional.ejemplo.repositorio.IRepositorio;

import java.util.Optional;

public class EjemploRepositorioMetodoOrElseThrow {
    public static void main(String[] args) {
        IRepositorio<Computador> repo = new ComputadorRepositorio();
        Computador pc = repo.filtrar("Asusu").orElseThrow(); //sino se encuentra devuekve un objeto Computador
        //orElseThrow - sino lanza una exception, get se maneja en conjunto con el ispresent
        Computador pc1 = repo.filtrar("Asusu").orElseThrow(() -> new IllegalStateException()); //sino se encuentra devuekve un objeto Computador
        System.out.println(pc1);

        String archivo = "documento.pdf";
        String extension = Optional.ofNullable(archivo)
                .filter(a -> a.contains("."))
                .map(a -> a.substring(archivo.lastIndexOf(".")))
                .orElseThrow(); //estricto si no contiene el putno
        System.out.println(extension);


    }
}
