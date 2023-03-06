package com.nikki.poointerfaces.repositorio;

import com.nikki.poointerfaces.modelo.Cliente;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ClienteListRepositorio implements OrdenablePaginableCrudRepositorio{
    private List<Cliente> dataSource; //Almacena los datos y realiza las operaciones

    public ClienteListRepositorio() {
        this.dataSource = new ArrayList<>();
    }

    public ClienteListRepositorio(List<Cliente> dataSource) {
        this.dataSource = new ArrayList<>();
    }

    @Override
    public List<Cliente> listar() {
        return dataSource;
    }

    @Override
    public Cliente buscarId(Integer id) {
        Cliente c = null;
        for(Cliente cliente :dataSource){
            if(cliente.getId()!= null && cliente.getId().equals(id)){
                c = cliente;
                break;
            }
        }
        return c ;
    }

    @Override
    public void crear(Cliente cliente) {
        this.dataSource.add(cliente);
    }

    @Override
    public void actualizar(Cliente cliente) {
        Cliente cliente1 = this.buscarId(cliente.getId());
        cliente1.setNombre(cliente.getNombre());
        cliente1.setApellido(cliente.getApellido());
    }

    @Override
    public void eliminar(Integer id) {
        Cliente cliente = this.buscarId(id);
        this.dataSource.remove(cliente);
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



    @Override
    public List<Cliente> listar(int desde, int hasta) { //metodo interface de Paginaeble
        return dataSource.subList(desde, hasta);
    }

    @Override
    public int total() {
        return this.dataSource.size();
    }
}
