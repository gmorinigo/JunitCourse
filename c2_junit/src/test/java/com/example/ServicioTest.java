package com.example;

import com.example.core.Servicio;
import com.example.exceptions.SinDisponibilidad;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumingThat;

public class ServicioTest {
    Servicio servicio;

    @DisplayName("EVENTO @BeforeEach (initServicesTest)")
    @BeforeEach
    public void initServicesTest(){
        this.servicio = new Servicio("reparacion", 10, new BigDecimal(1000));
    }


    @Nested
    @DisplayName("Nombre tests")
    class nombreTests{

        @Test
        @DisplayName("Se verifica que el nombre del servicio sea correcto")
        public void verifyNombreTest(){
            Servicio servicio = new Servicio("reparacion", 10, new BigDecimal(1000));
            assertEquals("reparacion",servicio.getNombre());
            assertFalse(servicio.getNombre().equals("rep"));
        }

        @Test
        @DisplayName("Se verifica que el nombre del servicio sea correcto")
        public void verifySetNombreTest(){
            Servicio servicio = new Servicio("reparacion", 10, new BigDecimal(1000));
            servicio.setNombre("nombreNuevo");
            assertEquals("nombreNuevo",servicio.getNombre());
        }
    }

    @Test
    public void servicioConConstructorTest(){
        Servicio unServicio = new Servicio("nombreServicio",1,BigDecimal.ZERO);
        assertTrue(unServicio.getNombre() != null);
    }

    @Test
    @EnabledOnOs({OS.LINUX, OS.WINDOWS})
    public void referenciaServicioTest(){
        Servicio unServicio = new Servicio("nombreServicio",1,BigDecimal.ZERO);
        Servicio otroServicio = new Servicio("nombreServicio",1,BigDecimal.ZERO);
        assertEquals(unServicio,otroServicio);
    }

    @Test
    @DisabledOnOs({OS.LINUX, OS.MAC})
    public void sinDisponibilidadExceptionTest(){
        Exception ex = assertThrows(SinDisponibilidad.class,() -> {
            servicio.egresoDisponibilidad(20);
        });

        assertEquals(ex.getMessage(),"No hay disponibilidad Suficiente");
    }

    @DisplayName("Ingreso Disponibilidad parametrizado origen value")
    @ParameterizedTest(name="{displayName} -  Ejecución {index} ejecutado con el valor {0}")
    @ValueSource(strings = {"2","4","6","8","10"})
    void ingresoDisponibilidadParametrizadoTest(String disponibilidad) {
        //disponibilidad anterior
        int dispInt = Integer.parseInt(disponibilidad);
        int disponibilidadResultante = servicio.getDisponibilidad() + dispInt;

        // llamo al debito
        servicio.ingresoDisponibilidad(dispInt);

        // verfiico el saldo
        assertEquals(disponibilidadResultante ,servicio.getDisponibilidad());
    }

    @Test
    @DisplayName("set disponibilidad con assume")
    void setDisponibilidadTrue() {
        this.servicio.egresoDisponibilidad(10);
        //this.servicio.egresoDisponibilidad(5);
        boolean disponibilidadCero = servicio.getDisponibilidad()==0;

        // estas se ejecuta siempre
        assertEquals(servicio.getPrecio(),BigDecimal.valueOf(1000));

        // Solo ejecuta si habia disponibilidad cero
        //assumeTrue(disponibilidadCero);

        assumingThat(disponibilidadCero, () -> {
            ;
            servicio.setDisponibilidad(100);
            assertEquals(servicio.getDisponibilidad(), 100);
        });
    }

    @Test
    @DisplayName("set disponibilidad con assume")
    void setPrecioTest() {
        this.servicio.setPrecio(BigDecimal.valueOf(500));
        assertEquals(servicio.getPrecio(),BigDecimal.valueOf(500));
    }

    @Test
    @DisplayName("set disponibilidad con assume")
    void actalizarPrecioTest() {
        this.servicio.actalizarPrecio(BigDecimal.valueOf(200));
        assertEquals(servicio.getPrecio(),BigDecimal.valueOf(200));
    }
}
