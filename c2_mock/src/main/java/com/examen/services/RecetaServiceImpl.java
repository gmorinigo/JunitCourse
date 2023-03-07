package com.examen.services;

import com.examen.exceptions.RecetaNoEncontradaException;
import com.examen.models.Receta;
import com.examen.repositories.IngredientesRepository;
import com.examen.repositories.RecetaRepository;

import java.util.Optional;

public class RecetaServiceImpl implements RecetaService {

    private IngredientesRepository ingredientesRepository;

    private RecetaRepository recetaRepository;

    public RecetaServiceImpl (IngredientesRepository ingredientesRepository, RecetaRepository recetaRepository){
        this.ingredientesRepository = ingredientesRepository;
        this.recetaRepository = recetaRepository;
    }

    @Override
    public Optional<Receta> findRecetaByIngrediente(String ingrediente) {
        return recetaRepository.findAll().stream().filter(receta -> {
            //System.out.println(receta.getIngredientes());
            return receta.getIngredientes().contains(ingrediente);})
                .findFirst();
    }

    @Override
    public Receta findRecetaByNombre(String nombre) {
        Receta receta = recetaRepository.findByName(nombre);

        if (receta==null) throw new RecetaNoEncontradaException("Receta no encontrada findRecetaByNombre");

        return receta;
    }

    @Override
    public Receta save(Receta receta) {
        return recetaRepository.save(receta);
    }
}
