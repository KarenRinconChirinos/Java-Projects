package com.nikki.pooclasesabstractas.form;

import com.nikki.pooclasesabstractas.form.elementos.ElementoForm;
import com.nikki.pooclasesabstractas.form.elementos.InputForm;
import com.nikki.pooclasesabstractas.form.elementos.SelectForm;
import com.nikki.pooclasesabstractas.form.elementos.TextareaForm;
import com.nikki.pooclasesabstractas.form.elementos.select.Opcion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemploForm {
    public static void main(String[] args) {
        /*ElementoForm elementoForm = new ElementoForm() { //clase anonimas
            @Override
            public String dibujarHtml() {
                return null;
            }
        };*/

        InputForm username = new InputForm("username");
        InputForm password = new InputForm("contrasenia", "password");
        InputForm email =  new InputForm("email", "email");
        InputForm edad = new InputForm("edad", "number");
        TextareaForm experiencia = new TextareaForm("exp", 5,9);
        SelectForm lenguaje = new SelectForm("lenguaje");
        Opcion java = new Opcion("1","java");
        lenguaje.addOpcion(java)
                .addOpcion(new Opcion("2", "Python"))
                .addOpcion(new Opcion("3", "JavaScript"))
                .addOpcion(new Opcion("4", "TypeScript"))
                .addOpcion(new Opcion("5", "PHP "));

        username.setValor("john.doe");
        password.setValor("ab1bc2");
        email.setValor("john.doe@correo.com");
        edad.setValor("28");
        experiencia.setValor("18 años de experiencia");
        java.setSelected(true);

        /*List<ElementoForm> elementos = new ArrayList<>(); // se puede usar list como un tipo de arraylist
        elementos.add(username);
        elementos.add(password);
        elementos.add(email);
        elementos.add(edad);
        elementos.add(experiencia);
        elementos.add(lenguaje);*/

        List<ElementoForm> elementos = Arrays.asList(
                username,
                password,
                email,
                edad,
                experiencia,
                lenguaje); // se puede usar list como un tipo de arraylist


        /*for(ElementoForm e:elementos){
            System.out.println(e.dibujarHtml());
            System.out.println("<br>");
        }*/

        //API Stream
        elementos.forEach(e ->{
            System.out.println(e.dibujarHtml());
            System.out.println("<br>");
        });
    }
}
