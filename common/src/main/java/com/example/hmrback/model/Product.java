package com.example.hmrback.model;

import com.example.hmrback.persistence.enums.IngredientType;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import static com.example.hmrback.constant.ValidationConstants.IS_REQUIRED;

public record Product(
    Long id,

    @NotBlank(message = "Name" + IS_REQUIRED)
    String name,

    @JsonProperty("ingredient_type")
    @NotNull(message = "Ingredient type" + IS_REQUIRED)
    IngredientType ingredientType
) {}
