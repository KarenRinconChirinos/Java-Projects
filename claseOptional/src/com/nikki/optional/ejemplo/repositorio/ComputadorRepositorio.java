package com.nikki.optional.ejemplo.repositorio;

import com.nikki.optional.ejemplo.models.Computador;
import com.nikki.optional.ejemplo.models.Fabricante;
import com.nikki.optional.ejemplo.models.Procesador;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ComputadorRepositorio implements IRepositorio {
    private List<Computador> dataSource;
    public ComputadorRepositorio() {
        dataSource = new ArrayList<>();
        Procesador proc = new Procesador("19-99888H", new Fabricante("Intel"));
        Computador asus = new Computador("Asus ROG", "Strix G512");
        asus.setProcesador(proc);
        dataSource.add(asus);
        dataSource.add(new Computador("Asusu", "Strx G512"));
        dataSource.add(new Computador("MacBook Pro", "MVVK2C1"));
    }

    @Override
    public Optional<Computador> filtrar(String nombre) {
/*        for(Computador c: dataSource){
            if(c.getNombre().equalsIgnoreCase(nombre)){
                return Optional.of(c);
            }
        }
        return Optional.empty();*/
        return dataSource.stream()
                .filter(c -> c.getNombre().equalsIgnoreCase(nombre))
                .findFirst(); //devuelve el pimer optional o un optional vacio
    }

}
