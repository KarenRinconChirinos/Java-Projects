package com.nikki.pooHerenciaCompania.ejemplos;

import com.nikki.pooHerencia.Compania.Gerente;

public class EjemploCompania {
    public static void main(String[] args) {
        Gerente gerente =  new Gerente("Juan", "Manio", 10000d);
        gerente.setPresupuesto( 800d);
        gerente.setNumeroFiscal("A9RFGHF000");
        gerente.setDireccion("Calle Coyote, Avenida Principal");
        gerente.aumentarRemuneracion(10);
        System.out.println(gerente);

        System.out.println("---------------------------------------------------- ");
        Gerente gerente2 =  new Gerente("Mario", "Caston", 10000d);
        gerente.setPresupuesto(12000d);
        gerente.setNumeroFiscal("A9RFGHF000");
        gerente.setDireccion("Calle Coyote, Avenida Principal");
        gerente.aumentarRemuneracion(10);
        System.out.println(gerente);

    }
}
