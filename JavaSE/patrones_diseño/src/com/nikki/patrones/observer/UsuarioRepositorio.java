package com.nikki.patrones.observer;

import java.util.ArrayList;
import java.util.List;

public class UsuarioRepositorio extends Observable{
    private List<String> repositorio = new ArrayList<>();
    public void crearUsuario(String usuario){
        repositorio.add(usuario);
        //cada que se agrega se notifica
        notifyObservers();
    }

}
