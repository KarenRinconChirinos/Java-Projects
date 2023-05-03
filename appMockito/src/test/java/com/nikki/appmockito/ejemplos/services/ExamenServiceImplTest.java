package com.nikki.appmockito.ejemplos.services;

import com.nikki.appmockito.ejemplos.models.Examen;
import com.nikki.appmockito.ejemplos.repositories.ExamenRepository;
import com.nikki.appmockito.ejemplos.repositories.PreguntaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ExamenServiceImplTest {
    ExamenRepository repository;
    ExamenService service;
    PreguntaRepository preguntaRepository;

    @BeforeEach
    void setUp() {
        //entre mock(se pasa el nombre de la interfaz o de la clase que querems simular
        repository = Mockito.mock(ExamenRepository.class);
        preguntaRepository = mock(PreguntaRepository.class);
        service = new ExamenServiceImpl(repository, preguntaRepository);
    }

    @Test
    void findExamenPorNombre() {
        //when viene de mockito
        when(repository.findAll()).thenReturn(Datos.EXAMENES);
        //cuando se invoque el metodo del reporsitorio entonces, devolvemos una lista    de datos

        Optional<Examen> examen = service.findExamenPorNombre("Matematicas");


        assertTrue(examen.isPresent());
        assertEquals(5L, examen.orElseThrow().getId());
        assertEquals("Matematicas", examen.get().getNombre() );
    }


    @Test
    void findExamenPorNombreListaVacia() {
        //datos de ejemplo
        List<Examen> datos = Collections.emptyList();
        //when viene de mockito
        when(repository.findAll()).thenReturn(datos);
        //cuando se invoque el metodo del reporsitorio entonces, devolvemos una lista    de datos

        Optional<Examen> examen = service.findExamenPorNombre("Matematicas");
        
        assertFalse(examen.isPresent());
    }

    @Test
    void testPreguntasExamen() {
        when(repository.findAll()).thenReturn(Datos.EXAMENES);
        when(preguntaRepository.findPreguntasPorExamenId(5l)).thenReturn(Datos.PREGUNTAS);
        Examen examen = service.findExamenPorNombreConPreguntas("Matenaticas");
        assertEquals(4, examen.getPreguntas().size());

    }
}