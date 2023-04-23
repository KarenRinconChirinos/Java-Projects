package com.nikki.recursividad.ejemplo;

import com.nikki.recursividad.ejemplo.models.Componente;

import java.util.stream.Stream;

public class EjemploRecursividad {
    public static void main(String[] args) {
        Componente pc = new Componente("Gabinete PC ATX");
        Componente poder = new Componente("Fuente de Poder 700w");
        Componente placaMadre = new Componente("MainBoard Asus socket AMD");
        Componente cpu = new Componente("CPU AMD Ryzen 5 2000");
        //componentes de la cpu
        Componente ventilador = new Componente("Ventilador CPU");
        Componente disipador = new Componente("Disipador");
        Componente tv = new Componente("Nvidia RTX 3080 8GB ");
        Componente gpu = new Componente("Nvidia RTX 3080 8GB ");
        Componente gpuRam = new Componente("4GB Ram");
        Componente gpuRam2 = new Componente("4GB Ram");
        Componente gpuVentiladores = new Componente("Ventiladores");
        Componente ram = new Componente("Memoria Ram 32GB");
        Componente ssd = new Componente("Disco SSD 2T");

        cpu.addComponente(ventilador)
                .addComponente(disipador);

        tv.addComponente(gpu)
                .addComponente(gpuRam)
                .addComponente(gpuRam2)
                .addComponente(gpuVentiladores);
        placaMadre.addComponente(cpu)
                .addComponente(tv)
                .addComponente(ram)
                .addComponente(ssd);

        pc.addComponente(poder)
                .addComponente(placaMadre)
                .addComponente(new Componente("Teclado"))
                .addComponente(new Componente("Mouse"));

        metodoRecursivoStream(pc, 0)
                .forEach(c -> System.out.println("\t".repeat(c.getNivel()) + c.getNombre()));//lo invoca el padre

        metodoRecursivo(pc, 0);
    }

    public static Stream<Componente> metodoRecursivoStream(Componente c, int nivel){
        c.setNivel(nivel);
        return Stream.concat(Stream.of(c), c.getHijos().stream().flatMap( hijo -> metodoRecursivoStream(hijo, nivel + 1)));
    }

    public static void metodoRecursivo(Componente c, int nivel){
        System.out.println("\t".repeat(nivel) + c.getNombre());
        if(c.tieneHijos()){
            for (Componente hijo: c.getHijos()){
                metodoRecursivo(hijo, nivel + 1);
            }
        }
    }

}
