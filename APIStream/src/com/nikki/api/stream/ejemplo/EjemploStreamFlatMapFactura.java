package com.nikki.api.stream.ejemplo;

import com.nikki.api.stream.ejemplo.models.Factura;
import com.nikki.api.stream.ejemplo.models.Usuario;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class EjemploStreamFlatMapFactura {
    public static void main(String[] args) {
        Usuario u1 = new Usuario("Jhon", "Doe");
        Usuario u2 = new Usuario("Pepe", "Mar");

        u1.addFactura(new Factura("Compras tecnologia"));
        u1.addFactura(new Factura("Compras muebles"));
        u2.addFactura(new Factura("Bicicleta"));
        u2.addFactura(new Factura("Notebook Gamer"));

        //forma dificil
        List<Usuario> usuarios = Arrays.asList(u1,u2);
        for(Usuario u: usuarios){
            for(Factura f: u.getFacturas()){
                System.out.println(f.getDescripcion());
            }
        }

        usuarios.stream()
                .flatMap(U -> U.getFacturas().stream())
                .forEach(f -> System.out.println(f.getDescripcion().concat(" : cliente ")
                        .concat(f.getUsuario().toString())));
    }
}
