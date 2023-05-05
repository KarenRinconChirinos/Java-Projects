package com.nikki.poointerfaces.repositorio;

import com.nikki.poointerfaces.modelo.BaseEntity;
import com.nikki.poointerfaces.modelo.Cliente;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class AbstractaListRepositorio <T extends BaseEntity> implements OrdenablePaginableCrudRepositorio<T>{
    protected List<T> dataSource; //Almacena los datos y realiza las operaciones
    //protected paara poderlo reutilizar

    public AbstractaListRepositorio() {
        this.dataSource = new ArrayList<>();
    }

    @Override
    public List<T> listar() {
        return dataSource;
    }

    @Override
    public void crear(T  t) {
        this.dataSource.add(t);
    }

    @Override
    public void eliminar(Integer id) {
        this.dataSource.remove(this.buscarId(id));
    }

    @Override
    public T buscarId(Integer id) {
        T c = null;
        for(T cliente :dataSource){
            if(cliente.getId()!= null && cliente.getId().equals(id)){
                c = cliente;
                break;
            }
        }
        return c ;
    }


    @Override
    public List<T> listar(int desde, int hasta) { //metodo interface de Paginaeble
        return dataSource.subList(desde, hasta);
    }

    @Override
    public int total() {
        return this.dataSource.size();
    }
}
