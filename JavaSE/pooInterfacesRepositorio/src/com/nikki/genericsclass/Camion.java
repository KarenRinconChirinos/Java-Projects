package com.nikki.genericsclass;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//Definicmos que la clase tiene un parametro generico
public class Camion<T> implements Iterable<T>{
    private List<T> objetos;
    private int max; // cantidad maxima de elementos a transportar

    public Camion(int max) {
        this.max = max;
        this.objetos =  new ArrayList<>();
    }

    public void add (T objeto){
        if(this.objetos.size() <= max){
            this.objetos.add(objeto);
        }else{//se lleno el camion
            throw new RuntimeException("No hay mas espacio en el camion.");
        }
    }

    @Override
    public Iterator<T> iterator() {
        return this.objetos.iterator();
    }
}
