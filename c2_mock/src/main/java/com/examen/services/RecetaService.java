package com.examen.services;

import com.examen.models.Receta;

import java.util.List;
import java.util.Optional;

public interface RecetaService {

    Optional<Receta> findRecetaByIngrediente(String ingrediente);

    Receta findRecetaByNombre(String materia);

    Receta save(Receta receta);
}
