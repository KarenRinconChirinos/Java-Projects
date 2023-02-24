package com.nikki.ejemplo;

import com.nikki.pooHerencia.Alumno;
import com.nikki.pooHerencia.AlumnoInternacional;
import com.nikki.pooHerencia.Persona;
import com.nikki.pooHerencia.Profesor;

public class ejemploHerenciaSobrecargatoString {
    public static void main(String[] args) {

        System.out.println("----------------- Creando la instancia de la clase Alumno -----------------");

        //se van encadenando llamadas de los contrucotres en la herencia, ya que al invocar al construcotr Alumno tambien se invoca el cnstrucotr de Persona

        //Una clase hija tambien e del tipo de su clase padre
        Persona alumno = new Alumno("Karen", "R", 16, "IPN"); // no permite acceder a los metodos de alumno porque es de tipo Persona
        ((Alumno) alumno).setNotaCastellano(5.5);
        ((Alumno) alumno).setNotaHistoria(6.0);
        ((Alumno) alumno).setNotaMatematica(8.7);
        ((Alumno) alumno).setEmail("alumno@sdffd.com");

        System.out.println("----------------- Creando la instancia de la clase AlumnoInternacional -----------------");
        AlumnoInternacional alumnoInternacional = new AlumnoInternacional("Franchesca", "Marcheano","Italia");
        alumnoInternacional.setEdad(18); //atributo de la clase persona
        alumnoInternacional.setInstitucion("IPN");
        alumnoInternacional.setNotaidiomas(9.0);
        alumnoInternacional.setNotaCastellano(8.0);
        alumnoInternacional.setNotaMatematica(6.7);
        alumnoInternacional.setNotaHistoria(9.8);
       alumnoInternacional.setEmail("alumnoInt@sdffd.com");


        System.out.println("----------------- Creando la instancia de la clase Profesor -----------------");
        Profesor profesor = new Profesor("Carlos", "M","Espanol");
        profesor.setEdad(29);
        profesor.setEmail("profesor@sdffd.com");


        System.out.println("---------------------------------------------------------------");
        imprimir(alumno);
        imprimir(alumnoInternacional);
        imprimir(profesor);
    }

    public static void imprimir(Persona persona){
        System.out.println("--------------------------------------------------------------------");
        System.out.println(persona); //invoca al metodo to string de forma implicita
    }
}
