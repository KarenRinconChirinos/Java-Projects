package com.nikki.poointerfaces.repositorio;

import com.nikki.poointerfaces.modelo.Cliente;

import java.util.List;

public interface crudRepositorio {
    List<Cliente> listar(); // fuente
    Cliente buscarId(Integer id); //obtener cliente por Id
    void crear(Cliente cliente);
    void actualizar(Cliente cliente);
    void eliminar(Integer id);
}
