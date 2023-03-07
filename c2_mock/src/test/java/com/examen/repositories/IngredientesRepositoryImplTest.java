package com.examen.repositories;

import com.examen.Datos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IngredientesRepositoryImplTest {

    IngredientesRepository ingredientesRepository;

    @DisplayName("EVENTO @BeforeEach (initServicesTest)")
    @BeforeEach
    public void initRepositoriesTest(){
        this.ingredientesRepository = new IngredientesRepositoryImpl();
    }

    @Test
    void findIngredientesByRecetaIdTest(){
       assertEquals(this.ingredientesRepository.findIngredientesByRecetaId(Long.valueOf(0)), Datos.INGREDIENTES);
    }

    @Test
    void saveTest(){
        assertEquals(this.ingredientesRepository.save(Datos.INGREDIENTES),Datos.INGREDIENTES.get(0));
    }
}
