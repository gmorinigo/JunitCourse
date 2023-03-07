package com.examen.repositories;

import com.examen.models.Receta;

import java.util.List;

public interface RecetaRepository {

    Receta save(Receta receta);
    List<Receta> findAll();
    Receta findByName(String nombre);
}
