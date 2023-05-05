package com.nikki.poointerfaces.repositorio;

import com.nikki.poointerfaces.modelo.BaseEntity;
import com.nikki.poointerfaces.modelo.Cliente;
import com.nikki.poointerfaces.repositorio.excepciones.EscrituraAccesoDatoException;
import com.nikki.poointerfaces.repositorio.excepciones.LecturaAccessoDatoException;
import com.nikki.poointerfaces.repositorio.excepciones.RegistroDuplicadoAccesoDatoException;

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
    //estos metodos no son obligatorios y se puede colocar codigo porque no es un metodo abstracto

    @Override
    public void crear(T  t) throws EscrituraAccesoDatoException {
        if(t == null){
            throw new EscrituraAccesoDatoException("Error al insertar un objeto null");
        }
        if(this.dataSource.contains(t)){ // el metodo contains bsca el objeto por el id utilizando el equls
            throw new RegistroDuplicadoAccesoDatoException("Erro el objeto con id " + t.getId() + " existe en el repositorio");
        }
        this.dataSource.add(t);
    }

    @Override
    public void eliminar(Integer id) throws LecturaAccessoDatoException {
        this.dataSource.remove(this.buscarId(id));
    }

    @Override
    public T buscarId(Integer id) throws LecturaAccessoDatoException {
        if(id == null || id <= 0){
            //lanzamos una exception
            throw new LecturaAccessoDatoException("Id invalido, debe er > 0");
            //se maneja en el metodo que la utiliza y maniupla
        }
        T c = null;
        for(T cliente :dataSource){
            if(cliente.getId()!= null && cliente.getId().equals(id)){
                c = cliente;
                break;
            }
        }
        if(c == null){
            throw new LecturaAccessoDatoException("No eixste el registro con id: " +  id);
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
