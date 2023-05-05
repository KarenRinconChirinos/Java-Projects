package com.nikki.poointerfaces.repositorio.lista;

import com.nikki.poointerfaces.modelo.Cliente;
import com.nikki.poointerfaces.repositorio.AbstractaListRepositorio;
import com.nikki.poointerfaces.repositorio.Direccion;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ClienteListRepositorio extends AbstractaListRepositorio<Cliente> {

   @Override
    public void actualizar(Cliente t) {
        Cliente cliente1 = this.buscarId(t.getId());
        cliente1.setNombre(t.getNombre());
        cliente1.setApellido(t.getApellido());
    }


    @Override
    public List<Cliente> listar(String campo, Direccion dir) { //metodo de iterface Ordenable
        List<Cliente> listaOrdenada = new ArrayList<>(this.dataSource);
        listaOrdenada.sort(new Comparator<Cliente>() {
            @Override
            public int compare(Cliente a, Cliente b) {//usamos expresion lambda para el metodo compare
                    int resultado =  0;
                    if(dir == Direccion.ASC){
                       resultado = ordenar(campo, a, b);
                    }else if(dir == Direccion.DESC){
                       resultado = ordenar(campo, b, a);
                    }
                    return resultado;
            }
        });
        return listaOrdenada;
    }


    public static int ordenar (String campo, Cliente a, Cliente b ){
        int resultado = 0;
        switch(campo){
            case "id" ->
                    resultado = a.getId().compareTo(b.getId());
            case "nombre" ->
                    resultado = a.getNombre().compareTo(b.getNombre());
            case "apellido" ->
                    resultado =  a.getApellido().compareTo(b.getApellido());
        }
        return resultado;
    }


}
