package com.nikki.colecciones.ejemplos.list;

import com.nikki.colecciones.ejemplos.modelo.Alumno;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EjemploArrayList {
    public static void main(String[] args) {
        List<Alumno> ArrayListAlumno = new ArrayList<>(); //si el nombre es igual a la nnombreo, no se reiteta
        System.out.println(ArrayListAlumno + ", size: " + ArrayListAlumno.size());
        System.out.println("esta vacia la lista: " + ArrayListAlumno.isEmpty());
        ArrayListAlumno.add(new Alumno("Pato", 5));
        ArrayListAlumno.add(new Alumno("Cata", 6));
        ArrayListAlumno.add(new Alumno("Luci", 4));
        ArrayListAlumno.add(2, new Alumno("Jano", 7)); // se guarda en la posicion 2
        ArrayListAlumno.set(3, new Alumno("Andres", 3));
        System.out.println(ArrayListAlumno + ", size: " + ArrayListAlumno.size());
        //ArrayListAlumno.remove(new Alumno("Jano", 7));
        ArrayListAlumno.remove(2);

        System.out.println(ArrayListAlumno + ", size: " + ArrayListAlumno.size());
        boolean b = ArrayListAlumno.contains(new Alumno("Jano", 7));
        System.out.println("La lista contiene a Jano = " + b);

        Object a[] = ArrayListAlumno.toArray();
        for(int i=0; i<a.length; i++){
            System.out.println("Desde el arreglo = " + a[i]);
        }
    }
}
