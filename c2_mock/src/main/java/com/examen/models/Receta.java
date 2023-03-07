package com.examen.models;

import com.examen.Datos;

import java.util.ArrayList;
import java.util.List;

public class Receta {

    private Long id;
    private String receta;
    private List<String> ingredientes;

    public Receta(Long id, String receta) {
        this.id = id;
        this.receta = receta;
        this.ingredientes = new ArrayList<>();
    }
    public Receta(Long id, String receta, List<String> ingredientes) {
        this.id = id;
        this.receta = receta;
        this.ingredientes = new ArrayList<>();
        this.ingredientes.addAll(ingredientes);
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReceta() {
        return receta;
    }

    public void setReceta(String receta) {
        this.receta = receta;
    }

    public List<String> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<String> ingredientes) {
        this.ingredientes = ingredientes;
    }
}
