package com.nikki.poointerfaces.repositorio;
import com.nikki.poointerfaces.repositorio.excepciones.AccesoDatosException;
import com.nikki.poointerfaces.repositorio.excepciones.LecturaAccessoDatoException;

import java.util.List;

public interface crudRepositorio <T> {
    List<T> listar(); // fuente
    T buscarId(Integer id) throws AccesoDatosException; //obtener cliente por Id
    //Toma y tira todas las clases hijas de AccesoDatoException
    void crear(T object) throws AccesoDatosException;
    void actualizar(T o) throws AccesoDatosException;
    void eliminar(Integer id) throws LecturaAccessoDatoException;
}
