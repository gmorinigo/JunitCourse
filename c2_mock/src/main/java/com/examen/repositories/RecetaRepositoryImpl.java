package com.examen.repositories;

import com.examen.Datos;
import com.examen.models.Receta;

import java.util.List;

public class RecetaRepositoryImpl implements RecetaRepository{
    @Override
    public Receta save(Receta receta) {
        return Datos.RECETAS.get(0);
    }

    @Override
    public List<Receta> findAll() {
        System.out.println("RecetaRepository Sin Mock");
        return Datos.RECETAS;
    }

    @Override
    public Receta findByName(String nombre) {
        return Datos.RECETAS.stream().filter(rec -> rec.getReceta().equals(nombre))
                .findAny().orElse(null);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof RecetaRepositoryImpl)) return false;

        RecetaRepositoryImpl receta = (RecetaRepositoryImpl) obj;

        // No tiene atributos, si es instancia son iguales
        return true;
    }
}
