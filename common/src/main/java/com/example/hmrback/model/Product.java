package com.example.hmrback.model;

import com.example.hmrback.persistence.enums.IngredientType;
import com.fasterxml.jackson.annotation.JsonProperty;

public record Product(
    Long id,
    String name,
    @JsonProperty("ingredient_type")
    IngredientType ingredientType
) {}
