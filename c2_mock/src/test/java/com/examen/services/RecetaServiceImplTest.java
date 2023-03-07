package com.examen.services;

import com.examen.Datos;
import com.examen.exceptions.RecetaNoEncontradaException;
import com.examen.models.Receta;
import com.examen.repositories.IngredientesRepository;
import com.examen.repositories.IngredientesRepositoryImpl;
import com.examen.repositories.RecetaRepository;
import com.examen.repositories.RecetaRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RecetaServiceImplTest {
    @Mock
    IngredientesRepositoryImpl ingredientesRepository;

    @Mock
    RecetaRepositoryImpl recetaRepository;

    @InjectMocks
    RecetaServiceImpl recetaService;

    @Captor
    ArgumentCaptor<Receta> captor;

    @BeforeEach
    void setUp() {
        // NADA PORQUE ESTOY USANDO INYECCION DE DEPENDENCIAS
    }

    @Test
    void creacionRecetaServiceImplTest(){
        IngredientesRepository ingredientesRepository = new IngredientesRepositoryImpl();

        RecetaRepository recetaRepository = new RecetaRepositoryImpl();

        RecetaService recetaService = new RecetaServiceImpl(ingredientesRepository,recetaRepository);

        Optional<Receta> recetaCons =  recetaService.findRecetaByIngrediente("Mozzarella");

        assertTrue(recetaCons.isPresent());
        assertEquals(9L, recetaCons.get().getId());
        assertEquals("Pizza", recetaCons.get().getReceta());

    }

    @Test
    void findRecetaByNameMockTest(){
        when(recetaRepository.findByName(anyString())).thenReturn(Datos.RECETA_PIZZA_OK);
        Receta recetaCons =  recetaService.findRecetaByNombre("Pizza");

        assertEquals(Datos.RECETA_PIZZA_OK.getId(), recetaCons.getId());
        assertEquals(Datos.RECETA_PIZZA_OK.getReceta(), recetaCons.getReceta());

        verify(recetaRepository).findByName(anyString());
    }

    @Test
    @DisabledOnOs({OS.LINUX, OS.MAC})
    void findRecetaByNameSinMockTest(){

        IngredientesRepository ingredientesRepository = new IngredientesRepositoryImpl();
        RecetaRepository recetaRepository = new RecetaRepositoryImpl();
        RecetaService recetaService = new RecetaServiceImpl(ingredientesRepository,recetaRepository);

        Receta recetaCons =  recetaService.findRecetaByNombre("Pizza");

        assertEquals(Datos.RECETA_PIZZA_OK.getId(), recetaCons.getId());
    }

    @Test
    @DisabledOnOs({OS.LINUX, OS.MAC})
    void findByNameExceptionTest(){

        IngredientesRepository ingredientesRepository = new IngredientesRepositoryImpl();
        RecetaRepository recetaRepository = new RecetaRepositoryImpl();
        RecetaService recetaService = new RecetaServiceImpl(ingredientesRepository,recetaRepository);

        Exception ex = assertThrows(RecetaNoEncontradaException.class,() -> {
            recetaService.findRecetaByNombre("ALGO");
        });

        assertEquals(ex.getMessage(),"Receta no encontrada findRecetaByNombre");
    }

    @Test
    void findByNameMockExceptionTest(){
        when(recetaRepository.findByName(anyString())).thenThrow(new IllegalArgumentException());

        assertThrows(IllegalArgumentException.class, () -> recetaService.findRecetaByNombre("Pizza"));
    }

    @Test
    void argumentMatchersTest(){
        when(recetaRepository.findByName(anyString())).thenReturn(Datos.RECETA_PIZZA_OK);
        Receta recetaCons =  recetaService.findRecetaByNombre("Pizza");

        verify(recetaRepository).findByName("Pizza");
        verify(recetaRepository).findByName(argThat(arg -> arg != null && arg.equals("Pizza")));
    }

    @Test
    void ArgumentCaptorSaveTest() {
        when(recetaRepository.save(Datos.RECETA_PIZZA_OK)).thenReturn(Datos.RECETA_PIZZA_OK);
        Receta recetaCons =  recetaService.save(Datos.RECETA_PIZZA_OK);

        verify(recetaRepository).save(captor.capture());

        System.out.println(captor.getValue());
        assertEquals(Datos.RECETA_PIZZA_OK.getId(), captor.getValue().getId());
    }

    @Test
    void DoThrowsExceptionTest() {
        doThrow(IllegalArgumentException.class).when(recetaRepository).save(any(Receta.class));

        assertThrows(IllegalArgumentException.class, () -> recetaService.save(Datos.RECETA_PIZZA_OK));
    }

    @Test
    void testDoCallRealMethod() {
        doCallRealMethod().when(recetaRepository).findByName(anyString());
        Receta recetaCons =  recetaService.findRecetaByNombre("Malfatti");
        assertEquals(6L, recetaCons.getId());
        assertEquals("Malfatti", recetaCons.getReceta());
    }
}
