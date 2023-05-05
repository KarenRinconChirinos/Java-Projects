package com.nikki.java.jdbc;

import com.nikki.java.jdbc.modelo.Usuario;
import com.nikki.java.jdbc.repositorio.Repositorio;
import com.nikki.java.jdbc.repositorio.UsuarioRepositorioImpl;

import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;

public class Ejemplo {
    public static void main(String[] args) {
        int opcionIndice = 0;
        int cont = 1;
        Map<String, Integer> operaciones = new HashMap();
        operaciones.put("Actualizar", 1);
        operaciones.put("Eliminar", 2);
        operaciones.put("Agregar", 3);
        operaciones.put("Listar", 4);
        operaciones.put("Salir", 5);

        Object[] opArreglo = operaciones.keySet().toArray();

        do{
            Object opcion = JOptionPane.showInputDialog(null,
                    "Seleccione un Operación",
                    "Mantenedor de Usuarios",
                    JOptionPane.INFORMATION_MESSAGE, null, opArreglo, opArreglo[0]);

            if (opcion == null) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una operación");
            } else {
                opcionIndice = operaciones.get(opcion.toString());
                Repositorio<Usuario> repoUser = new UsuarioRepositorioImpl();
                int id;
                Usuario usuario = new Usuario();
                String username;
                String password;
                String email;
                switch (opcionIndice){
                    case 1 -> {
                        id = Integer.valueOf(JOptionPane.showInputDialog(null, "Ingresar el id: ", "Actualizar"));
                        usuario = repoUser.porId(id);
                        if (usuario != null) {
                            username = JOptionPane.showInputDialog(null, "Ingresar el username:", usuario.getUsername());
                            password = JOptionPane.showInputDialog(null, "Ingresar el password:", usuario.getPassword());
                            email = JOptionPane.showInputDialog(null, "Ingresar el email:", usuario.getEmail());

                            usuario.setUsername(username);
                            usuario.setPassword(password);
                            usuario.setEmail(email);

                            repoUser.crear(usuario);
                            JOptionPane.showMessageDialog(null, "Usuario actualizado correctamente");
                        } else {
                            JOptionPane.showMessageDialog(null, "No existe este id");
                        }
                    }
                    case 2 -> {
                            id = Integer.valueOf(JOptionPane.showInputDialog(null, "Ingresar el id del usuario para eliminar:"));
                            repoUser.eliminar(id);
                            JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente");
                    }
                    case 3 -> { //agregar
                            username = JOptionPane.showInputDialog(null, "Ingresar el username para un nuevo usuario:");
                            password = JOptionPane.showInputDialog(null, "Ingresar el password:");
                            email = JOptionPane.showInputDialog(null, "Ingresar el email:");

                            usuario.setUsername(username);
                            usuario.setPassword(password);
                            usuario.setEmail(email);

                            repoUser.crear(usuario);
                            JOptionPane.showMessageDialog(null, "Usuario agregado correctamente");
                    }
                    case 4 -> {
                        repoUser.listar().forEach(System.out::println);
                    }
                    case 5 -> {
                        JOptionPane.showMessageDialog(null,"Salir! \n Adios Vaquero!");
                        cont = 0;
                    }
                }
            }
        }while (cont != 0);
    }
}
