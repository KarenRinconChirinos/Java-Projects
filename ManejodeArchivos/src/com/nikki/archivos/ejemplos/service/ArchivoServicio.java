package com.nikki.archivos.ejemplos.service;

import java.io.*;
import java.util.Scanner;
import java.util.function.Predicate;

public class ArchivoServicio {
    public void crearArchivo(String nombre){
        File archivo  = new File(nombre);
        try (FileWriter escritor = new FileWriter(archivo, true)) {
            /*escritor.append("Hola que tal amigos\n")
                    .append("Estoy haciendo un archivo y escribiendo en el ")
                    .append("Bye");
            escritor.close();*/

            PrintWriter buffer = new PrintWriter(escritor);
            buffer.println("Hola que tal amigos\n");
            buffer.println("Estoy haciendo un archivo y escribiendo en el ");
        buffer.println("Bye");
            //buffer.close();
            System.out.println("Se creo correctamente");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void crearArchivo2(String nombre){
        File archivo  = new File(nombre);
        try {
            FileWriter escritor = new FileWriter(archivo, true);
            /*escritor.append("Hola que tal amigos\n")
                    .append("Estoy haciendo un archivo y escribiendo en el ")
                    .append("Bye");
            escritor.close();*/

            BufferedWriter buffer = new BufferedWriter(escritor);
            buffer.append("Hola que tal amigos\n")
                    .append("Estoy haciendo un archivo y escribiendo en el ")
                    .append("Bye");
            buffer.close();
            System.out.println("Se creo correctamente");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String leerArchivo(String nombre){
        StringBuilder sb = new StringBuilder();
        File file = new File(nombre);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String linea = reader.readLine();
            while (linea != null){
                sb.append(linea);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }


    public String leerArchivo2(String nombre){
        StringBuilder sb = new StringBuilder();
        File file = new File(nombre);
        try (Scanner s = new Scanner(file)){
            s.useDelimiter("\n");
            while (s.hasNext()){
                sb.append(s.next()).append("\n");
            }
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }
}
