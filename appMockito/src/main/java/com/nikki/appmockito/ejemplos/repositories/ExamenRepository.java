package com.nikki.appmockito.ejemplos.repositories;

import com.nikki.appmockito.ejemplos.models.Examen;

import java.util.List;

public interface ExamenRepository {
    List<Examen> findAll();
}
