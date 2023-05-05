package com.nikki.ejemplo;

import com.nikki.pooHerencia.*; //importamos todas la clase del ese paquete

public class ejemploHerencia {
    public static void main(String[] args) {

        System.out.println("----------------- Creando la instancia de la clase Alumno -----------------");

        //se van encadenando llamadas de los contrucotres en la herencia, ya que al invocar al construcotr Alumno tambien se invoca el cnstrucotr de Persona

        //Una clase hija tambien e del tipo de su clase padre
        //Se podria hacer un cast de Persona para Alumno y invocar sus metodos de alumno
        Persona alumno = new Alumno(); // no permite acceder a los metodos de alumno porque es de tipo Persona
        alumno.setNombre("Karen"); // metodo heredado de la clase padre

        //tomar en cuenta que cuando es protected no se puede acceder a el ya que no estan ene el mismo paquete
        //alumno.nombre = "Karen"; //la variable nombre esta declara como protected dentro de la clase, lo que permite invocarla directamente desde la referencia
        alumno.setApellido("R"); //metodo heredado de clase Persona
        ((Alumno)alumno).setInstitucion("IPN"); // se realiza un cast - se forza a
        ((Alumno) alumno).setNotaCastellano(5.5);
        ((Alumno) alumno).setNotaHistoria(6.0);
        ((Alumno) alumno).setNotaMatematica(8.7);


        System.out.println("----------------- Creando la instancia de la clase AlumnoInternacional -----------------");
        AlumnoInternacional alumnoInternacional = new AlumnoInternacional();
        alumnoInternacional.setNombre("Franchesca"); //atributo de la clase Persona
        alumnoInternacional.setApellido("Marcheano"); //atributo de la clase Persona
        alumnoInternacional.setPais("Italia"); //atributo de la clase AlumnoInternacional
        alumnoInternacional.setEdad(18); //atributo de la clase persona
        alumnoInternacional.setInstitucion("IPN");
        alumnoInternacional.setNotaidiomas(9.0);
        alumnoInternacional.setNotaCastellano(8.0);
        alumnoInternacional.setNotaMatematica(6.7);
        alumnoInternacional.setNotaHistoria(9.8);


        System.out.println("----------------- Creando la instancia de la clase Profesor -----------------");
        Profesor profesor = new Profesor();
        profesor.setNombre("Carlos"); // metodo heredado de la clase padre
        profesor.setApellido("M"); //metodo heredado de clase Persona
        profesor.setAsignatura("Espanol"); //metodo propio de la clase Profesor

        System.out.println("---------------------------------------------------------------");


        System.out.println(alumno.getNombre()
                + " " + alumno.getApellido()
                + " " + ((Alumno) alumno).getInstitucion());


        System.out.println(alumnoInternacional.getNombre()
                + " " + alumnoInternacional.getApellido()
                + " " + alumnoInternacional.getInstitucion()
                + " " + alumnoInternacional.getPais());


        System.out.println("Profesor de la asignatura de "
                + profesor.getAsignatura() + " es "
                + profesor.getNombre() + " "
                + profesor.getApellido() );


        Class clase =  alumnoInternacional.getClass();
        /*Primero itera en la clase alumnoInternaciona,
         luego en la superclase que seria Alumno y luego
          en la superclase  de Alumno que seria Persona*/

        while (clase.getSuperclass() != null){
            String hija = clase.getName();
            String padre =  clase.getSuperclass().getName();
            System.out.println(hija + " es un " + padre);
            clase =  clase.getSuperclass(); //le asigna su ancestro a la clase si es que tiene

        }

    }
}
