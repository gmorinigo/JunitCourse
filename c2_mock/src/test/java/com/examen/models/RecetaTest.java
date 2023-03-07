package com.examen.models;

import com.examen.Datos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RecetaTest {
    Receta receta;

    @DisplayName("EVENTO @BeforeEach (initServicesTest)")
    @BeforeEach
    public void initRepositoriesTest(){
        this.receta = new Receta(1L, "Pizza");
    }

    @Test
    void getIdTest(){
        assertEquals(this.receta.getId(),1L);
    }

    @Test
    void setIdTest(){
        this.receta.setId(88L);
        assertTrue(this.receta.getId()==88L);
    }

    @Test
    void getRecetaTest(){
        assertEquals(this.receta.getReceta(), "Pizza");
    }

    @Test
    void setRecetaTest(){
        this.receta.setReceta("nueva receta");
        assertTrue(this.receta.getReceta().equals("nueva receta"));
    }

    @Test
    void setIngredientesTest(){
        this.receta.setIngredientes(Datos.INGREDIENTES);
        assertEquals(this.receta.getIngredientes(),Datos.INGREDIENTES);
    }
}
