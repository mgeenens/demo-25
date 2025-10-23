package com.example.demo25.model;

import com.example.demo25.persistence.enums.IngredientType;

public record Product(
    Long id,
    String name,
    IngredientType ingredientType
) {}
