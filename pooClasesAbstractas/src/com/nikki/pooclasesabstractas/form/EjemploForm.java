package com.nikki.pooclasesabstractas.form;

import com.nikki.pooclasesabstractas.form.elementos.*;
import com.nikki.pooclasesabstractas.form.elementos.select.Opcion;
import com.nikki.pooclasesabstractas.form.validador.*;

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
        username.addValidador(new RequeridoValidador());

        InputForm password = new InputForm("contrasenia", "password");
        password.addValidador(new RequeridoValidador());
        password.addValidador(new LargoValidador(6,12));

        InputForm email =  new InputForm("email", "email");
        email.addValidador(new RequeridoValidador())
                .addValidador(new EmailValidador());

        InputForm edad = new InputForm("edad", "number");
        edad.addValidador(new NumeroValidador());

        TextareaForm experiencia = new TextareaForm("exp", 5,9);

        SelectForm lenguaje = new SelectForm("lenguaje");
        lenguaje.addValidador(new NoNuloValidador());
        Opcion java = new Opcion("1","java");
        lenguaje.addOpcion(java.setSelected())
                .addOpcion(new Opcion("2", "Python"))
                .addOpcion(new Opcion("3", "JavaScript"))
                .addOpcion(new Opcion("4", "TypeScript"))
                .addOpcion(new Opcion("5", "PHP "));

        ElementoForm saludar = new ElementoForm("saludo"){

            @Override
            public String dibujarHtml() {
                return "<input disabled name='" + this.nombre + "' value='" + this.valor + "'>";
            }
        };

        saludar.setValor("Hola que tal este campo esta desabilidato");
        username.setValor("john.doe");
        password.setValor("abbc2");
        email.setValor("john.doecorreo.com");
        edad.setValor("28");
        experiencia.setValor("18 años de experiencia");
        //java.setSelected(true);

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
                lenguaje,
                saludar); // se puede usar list como un tipo de arraylist


        /*for(ElementoForm e:elementos){
            System.out.println(e.dibujarHtml());
            System.out.println("<br>");
        }*/

        //API Stream
        elementos.forEach(e ->{
            System.out.println(e.dibujarHtml());
            System.out.println("<br>");
        });

        elementos.forEach( e->{
            if(!e.esValido()){
                e.getErrores().forEach(err ->{
                    System.out.println(err);
                });
            }
        });
    }
}
