package com.nikki.colecciones.ejemplos.set;

import com.nikki.colecciones.ejemplos.modelo.Alumno;

import static java.util.Comparator.comparing;// se mete a los metodos
import java.util.Set;
import java.util.TreeSet;

public class EjemploTreeSetComparable {
    public static void main(String[] args) {
        //Set<Alumno> treeSetAlumno = new TreeSet<>((a,b) -> a.getNombre().compareTo(b.getNombre())); //si el nombre es igual a la nnombreo, no se reiteta
        Set<Alumno> treeSetAlumno = new TreeSet<>(comparing(Alumno::getNota).reversed()); //si el nombre es igual a la nnombreo, no se reiteta

        treeSetAlumno.add(new Alumno("Pato", 5));
        treeSetAlumno.add(new Alumno("Cata", 6));
        treeSetAlumno.add(new Alumno("Luci", 4));
        treeSetAlumno.add(new Alumno("Jano", 7));
        treeSetAlumno.add(new Alumno("Andres", 3));
        treeSetAlumno.add(new Alumno("Zeus", 2));
        treeSetAlumno.add(new Alumno("Zeus", 2));

        System.out.println("treeSetAlumno = " + treeSetAlumno);
    }
}
