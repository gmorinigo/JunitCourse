package com.examen.repositories;

import com.examen.Datos;
import com.examen.exceptions.RecetaNoEncontradaException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RecetaRepositoryImplTest {

    RecetaRepositoryImpl recetaRepository;

    @DisplayName("EVENTO @BeforeEach (initServicesTest)")
    @BeforeEach
    public void initRepositoriesTest(){
        this.recetaRepository = new RecetaRepositoryImpl();
    }

    @Test
    @DisplayName("save test receta repository")
    void saveTest(){
        assertEquals(this.recetaRepository.save(Datos.RECETAS.get(0)), Datos.RECETAS.get(0));
    }

    @Test
    @DisplayName("findAll test receta repository")
    void findAllTest(){
        assertEquals(this.recetaRepository.findAll(), Datos.RECETAS);
    }

    @Test
    @DisplayName("equals test receta repository")
    void equalsTest(){
        RecetaRepositoryImpl otroRecetaRepository = new RecetaRepositoryImpl();
        assertEquals(this.recetaRepository, otroRecetaRepository);
    }

    @Test
    void findByNameTest(){
        assertEquals(9L,this.recetaRepository.findByName("Pizza").getId());
    }
}
