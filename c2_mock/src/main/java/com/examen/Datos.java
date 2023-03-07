package com.examen;

import com.examen.models.Receta;


import java.util.Arrays;
import java.util.List;

public class Datos {
    public final static List<Receta> RECETAS = Arrays.asList(new Receta(5L, "Risotto de Hongos"),
            new Receta(6L, "Malfatti",Arrays.asList("Arroz","Espinca",
                    "Oliva", "Harina", "Hongo")),
            new Receta(9L, "Pizza",Arrays.asList("Harina","Agua",
                    "Aceite", "Levadura", "Tomate", "Mozzarella")),
            new Receta(7L, "Focaccia"));

    public final static List<Receta>RECETAS_ID_NULL = Arrays.asList(new Receta(null, "Risotto de Hongos"),
            new Receta(null, "Malfatti"),
            new Receta(null, "Focaccia"));

    public final static List<Receta> RECETASS_ID_NEGATIVOS = Arrays.asList(new Receta(-5L, "Risotto de Hongos"),
            new Receta(-6L, "Malfatti"),
            new Receta(null, "Focaccia"));

    public final static List<String> INGREDIENTES = Arrays.asList("Arroz","Espinca",
            "Oliva", "Harina", "Hongo");

    public final static List<String> INGREDIENTES_PIZZA = Arrays.asList("Harina","Agua",
            "Aceite", "Levadura", "Tomate", "Mozzarella");

    public final static Receta RECETA= new Receta(null, "Pizza");

    public final static Receta RECETA_PIZZA_OK = new Receta(9L, "Pizza",Arrays.asList("Harina","Agua",
            "Aceite", "Levadura", "Tomate", "Mozzarella"));
}
