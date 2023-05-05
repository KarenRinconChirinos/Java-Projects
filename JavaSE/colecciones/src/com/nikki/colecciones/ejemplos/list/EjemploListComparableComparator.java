package com.nikki.colecciones.ejemplos.list;

import com.nikki.colecciones.ejemplos.modelo.Alumno;

import java.util.*;

public class EjemploListComparableComparator {
    public static void main(String[] args) {
        List<Alumno> ArrayListAlumno = new ArrayList<>(); //si el nombre es igual a la nnombreo, no se reiteta
        ArrayListAlumno.add(new Alumno("Pato", 5));
        ArrayListAlumno.add(new Alumno("Cata", 6));
        ArrayListAlumno.add(new Alumno("Luci", 4));
        ArrayListAlumno.add(new Alumno("Jano", 7));
        ArrayListAlumno.add(new Alumno("Andres", 3));
        ArrayListAlumno.add(new Alumno("Zeus", 2));
        ArrayListAlumno.add(new Alumno("Zeus", 3));
        ArrayListAlumno.add(new Alumno("Mau", 3));
        Alumno referencia = new Alumno("Mimi", 2);
        ArrayListAlumno.add(referencia);
        ArrayListAlumno.add(referencia);
        //Collections.sort(ArrayListAlumno,(a,b) -> a.getNota().compareTo(b.getNota()));
        //ArrayListAlumno.sort((a,b) -> a.getNota().compareTo(b.getNota()));
        ArrayListAlumno.sort(Comparator.comparing((Alumno a) ->a.getNota()).reversed());
        ArrayListAlumno.sort(Comparator.comparing(Alumno::getNota).reversed());

        System.out.println("ArrayList = " + ArrayListAlumno);
        System.out.println("\n\nIterando usando un foreach");
        for(Alumno  a : ArrayListAlumno){
            System.out.println(a);
        }
    }
}
