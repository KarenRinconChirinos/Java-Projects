package com.nikki.bolsasupermercado.repositorio;

public class BolsaSupermercado implements Ibolsa<T>{
    private List<T> lista;
    @Override
    public <T> void addProducto(T o) {
        this.lista.add(o);
    }

    @Override
    public List<T> obtenerProducto() {
        return null;
    }
}
