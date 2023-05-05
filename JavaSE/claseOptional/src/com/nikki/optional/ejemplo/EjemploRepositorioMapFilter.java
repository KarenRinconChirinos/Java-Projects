package com.nikki.optional.ejemplo;

import com.nikki.optional.ejemplo.models.Computador;
import com.nikki.optional.ejemplo.models.Fabricante;
import com.nikki.optional.ejemplo.repositorio.ComputadorRepositorio;
import com.nikki.optional.ejemplo.repositorio.IRepositorio;

public class EjemploRepositorioMapFilter {
    public static void main(String[] args) {
        IRepositorio<Computador> repo = new ComputadorRepositorio();
        Fabricante f  = repo.filtrar("asus")
                .flatMap(c -> c.getProcesador())
                .map(p -> p.getFabricante())
                .orElseThrow();

        System.out.println(f.getNombre());
    }
}
