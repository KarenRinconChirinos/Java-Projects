package com.nikki.colecciones.ejemplos.list;

import com.nikki.colecciones.ejemplos.modelo.Alumno;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class EjemploLinkedList {
    public static void main(String[] args) {
        //LinkedList - > tiene sus propios metodos y mas ademas de los list
        LinkedList<Alumno> LinkedListAlumno = new LinkedList<>(); //si el nombre es igual a la nnombreo, no se reiteta
        System.out.println(LinkedListAlumno + ", size: " + LinkedListAlumno.size());
        System.out.println("esta vacia la lista: " + LinkedListAlumno.isEmpty());
        LinkedListAlumno.add(new Alumno("Pato", 5));
        LinkedListAlumno.add(new Alumno("Cata", 6));
        LinkedListAlumno.add(new Alumno("Luci", 4));
        LinkedListAlumno.add(new Alumno("Jano", 7)); // se guarda en la posicion 2
        LinkedListAlumno.add(new Alumno("Andres", 3));

        System.out.println(LinkedListAlumno + ", size: " + LinkedListAlumno.size());
        LinkedListAlumno.addFirst(new Alumno("Zeus", 4 ));
        LinkedListAlumno.addLast(new Alumno("Mar", 9));
        System.out.println(LinkedListAlumno + ", size: " + LinkedListAlumno.size());

        System.out.println("primero: " + LinkedListAlumno.getFirst() + "\n ultimo: " +  LinkedListAlumno.getLast());
        System.out.println("primero: " + LinkedListAlumno.peekFirst() + "\n ultimo: " +  LinkedListAlumno.peekLast());
        System.out.println("indice: " + LinkedListAlumno.get(2));
        Alumno primero = LinkedListAlumno.removeFirst();
        LinkedListAlumno.removeLast();
        /*Alumno primero1 = LinkedListAlumno.pollFirst();
        LinkedListAlumno.pollLast();

        Alumno primero2 = LinkedListAlumno.pollFirst();
        LinkedListAlumno.pollLast();*/
        LinkedListAlumno.remove(new Alumno("Pato", 5));
        System.out.println(LinkedListAlumno + ", indice: " + LinkedListAlumno.indexOf(2));

        System.out.println(LinkedListAlumno + ", size: " + LinkedListAlumno.size());
        LinkedListAlumno.set(2, new Alumno("miau", 5));

        ListIterator<Alumno> li = LinkedListAlumno.listIterator();
        while(li.hasNext()){ //cursos avanza, no se puede retroceder porque es error
            Alumno a = li.next();
            System.out.println(a); //next retorna el objeto alumno
        }

        //ahora que el cursos avanzo y el puntero no es el primero
        while(li.hasPrevious()){ //
            Alumno a = li.previous();
            System.out.println(a); //next retorna el objeto alumno
        }
    }
}
