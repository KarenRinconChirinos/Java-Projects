package com.nikki.colecciones.ejemplos.set;

import com.nikki.colecciones.ejemplos.modelo.Alumno;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class EjemploHashSetUnicidad {
    public static void main(String[] args) {
        Set<Alumno> HashSetAlumno = new HashSet<>(); //si el nombre es igual a la nnombreo, no se reiteta
        HashSetAlumno.add(new Alumno("Pato", 5));
        HashSetAlumno.add(new Alumno("Cata", 6));
        HashSetAlumno.add(new Alumno("Luci", 4));
        HashSetAlumno.add(new Alumno("Jano", 7));
        HashSetAlumno.add(new Alumno("Andres", 3));
        HashSetAlumno.add(new Alumno("Zeus", 2));
        HashSetAlumno.add(new Alumno("Zeus", 3));
        HashSetAlumno.add(new Alumno("Mau", 3));
        Alumno referencia = new Alumno("Mimi", 2);
        HashSetAlumno.add(referencia);
        HashSetAlumno.add(referencia);

        System.out.println("HashSetAlumno = " + HashSetAlumno);
        System.out.println("\n\nIterando usando un foreach");
        for(Alumno  a : HashSetAlumno){
            System.out.println(a);
        }

        System.out.println("\n\nIterando usando un while y iterator");
        Iterator<Alumno> iterator = HashSetAlumno.iterator();
        while(iterator.hasNext()){
            Alumno a = iterator.next();
            System.out.println("a.getNombre() = " + a.getNombre());
        }

        System.out.print("\n\nIterando usando expresiones lambda");
        HashSetAlumno.forEach(a -> System.out.println(a));
        //HashSetAlumno.forEach(System.out::println); //optimizado

    }
}
