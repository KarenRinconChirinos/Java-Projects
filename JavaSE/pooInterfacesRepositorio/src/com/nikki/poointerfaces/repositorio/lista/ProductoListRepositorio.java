package com.nikki.poointerfaces.repositorio.lista;

import com.nikki.poointerfaces.modelo.Cliente;
import com.nikki.poointerfaces.modelo.Producto;
import com.nikki.poointerfaces.repositorio.AbstractaListRepositorio;
import com.nikki.poointerfaces.repositorio.Direccion;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProductoListRepositorio extends AbstractaListRepositorio<Producto> {
    @Override
    public List<Producto> listar(String campo, Direccion dir) {
        List<Producto> listaOrdenada = new ArrayList<>(this.dataSource);
        listaOrdenada.sort( (a, b) ->{
            int resultado =  0;
                if(dir == Direccion.ASC){
                    resultado = ordenar(campo, a, b);
                }else if(dir == Direccion.DESC){
                    resultado = ordenar(campo, b, a);
                }
                return resultado;
        });
        return listaOrdenada;
    }


    public static int ordenar (String campo, Producto a, Producto b ){
        int resultado = 0;
        switch(campo){
            case "id" ->
                    resultado = a.getId().compareTo(b.getId());
            case "descripcion" ->
                    resultado = a.getDescripcion().compareTo(b.getDescripcion());
            case "precio" ->
                    resultado =  a.getPrecio().compareTo(b.getPrecio());
        }
        return resultado;
    }

    @Override
    public void actualizar(Producto c) {
        Producto p = buscarId(c.getId());
        p.setDescripcion(c.getDescripcion());
        p.setPrecio(c.getPrecio());
    }
}
