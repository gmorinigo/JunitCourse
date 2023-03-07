package com.examen.repositories;

import java.util.List;

public interface IngredientesRepository {
    List<String> findIngredientesByRecetaId(Long id);

    String save(List<String> ingredientes);

}
