package com.nikki.appmockito.ejemplos.services;

import com.nikki.appmockito.ejemplos.models.Examen;
import com.nikki.appmockito.ejemplos.repositories.ExamenRepository;
import com.nikki.appmockito.ejemplos.repositories.PreguntaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

//habilitar anotaciones con
@ExtendWith(MockitoExtension.class)
class ExamenServiceImplTest {


    //atributos de given
    @Mock
    ExamenRepository repository;
    @InjectMocks
    ExamenServiceImpl service;
    @Mock
    PreguntaRepository preguntaRepository;

    @BeforeEach
    void setUp() {


        //habilitar el uso de anotaciones
        //MockitoAnnotations.openMocks(this);

        //entre mock(se pasa el nombre de la interfaz o de la clase que querems simular
        //repository = Mockito.mock(ExamenRepository.class);
        //preguntaRepository = mock(PreguntaRepository.class);
        //service = new ExamenServiceImpl(repository, preguntaRepository);
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
        when(preguntaRepository.findPreguntasPorExamenId(anyLong())).thenReturn(Datos.PREGUNTAS);
        Examen examen = service.findExamenPorNombreConPreguntas("Historia");
        assertEquals(5, examen.getPreguntas().size());
    }

    @Test
    void testPreguntasExamenVerify() {
        when(repository.findAll()).thenReturn(Datos.EXAMENES);
        when(preguntaRepository.findPreguntasPorExamenId(anyLong())).thenReturn(Datos.PREGUNTAS);
        Examen examen = service.findExamenPorNombreConPreguntas("Historia");
        //assertEquals(5, examen.getPreguntas().size());
        assertTrue(examen.getPreguntas().contains("integrales"));
        verify(repository).findAll();
        verify(preguntaRepository).findPreguntasPorExamenId(5l);
    }

    @Test
    void testNoExistePreguntasExamenVerify() {
        //given
        when(repository.findAll()).thenReturn(Datos.EXAMENES);
        when(preguntaRepository.findPreguntasPorExamenId(anyLong())).thenReturn(Datos.PREGUNTAS);
        //when - invocamos
        Examen examen = service.findExamenPorNombreConPreguntas("Historia");
        //assertEquals(5, examen.getPreguntas().size());

        //then probamos
        assertTrue(examen.getPreguntas().contains("integrales"));
        verify(repository).findAll();
        verify(preguntaRepository).findPreguntasPorExamenId(5l);
    }

    @Test
    void testguardarExamen() {
        //TEST DEVELOP DRIVEN
        //GIVEN(dado) - son las preondiciones en el entorno de prueba
        Examen newExamen = Datos.EXAMEN;
        newExamen.setPreguntas(Datos.PREGUNTAS);
        when(repository.guardar(any(Examen.class))).then(new Answer<Examen>(){
            Long secencia = 8L;
            @Override
            public Examen answer(InvocationOnMock invocationOnMock) throws Throwable {
                Examen examen = invocationOnMock.getArgument(0);
                examen.setId(secencia++);
                return examen;
            }
        });
        
        //when - invocamos
        Examen examen = service.guardar(newExamen);

        //then - probamos
        assertNotNull(examen.getId());
        assertEquals(8l, examen.getId());
        assertEquals("Fisica", examen.getNombre());
        verify(repository).guardar(any(Examen.class));
        verify(preguntaRepository).guardarVarias(anyList());
    }
}