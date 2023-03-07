package com.example.core;

import com.example.exceptions.SinDisponibilidad;

import java.math.BigDecimal;

public class Servicio {

    private  String nombre;

    private int disponibilidad;

    private BigDecimal precio;

    public Servicio(String nombre, int disponible,BigDecimal precio) {
        this.nombre = nombre;
        this.precio = precio;
        this.disponibilidad = disponible;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(int disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }


    public void ingresoDisponibilidad(int cantidad){
        this.disponibilidad += cantidad;
    }

    public void egresoDisponibilidad(int cantidad){
        if (this.disponibilidad < cantidad) throw new SinDisponibilidad("No hay disponibilidad Suficiente");

        this.disponibilidad -= cantidad;
    }

    public void actalizarPrecio(BigDecimal importe){
        this.precio=importe;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Servicio)) return false;

        Servicio servicio = (Servicio) obj;

        if (this.precio == null || this.nombre == null) return false;

        return (this.nombre.equals(servicio.getNombre()) && this.disponibilidad == servicio.getDisponibilidad() &&
                this.precio.equals(servicio.getPrecio()));
    }
}
