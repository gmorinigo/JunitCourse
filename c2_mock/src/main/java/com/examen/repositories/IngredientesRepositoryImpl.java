package com.examen.repositories;

import com.examen.Datos;

import java.util.List;

public class IngredientesRepositoryImpl implements IngredientesRepository{

    @Override
    public List<String> findIngredientesByRecetaId(Long id) {
        return Datos.INGREDIENTES;
    }

    @Override
    public String save(List<String> ingredientes) {
        System.out.println("save Ingredientes real");
        return Datos.INGREDIENTES.get(0);
    }
}
