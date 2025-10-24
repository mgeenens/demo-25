package com.example.demo25.model;

import com.example.demo25.persistence.enums.RecipeType;

import java.time.LocalDate;
import java.util.List;

public record Recipe(Long id,
                     String title,
                     String description,
                     Integer preparationTime,
                     RecipeType recipeType,
                     String publicationDate,
                     User user,
                     List<Ingredient> ingredientList,
                     List<Step> stepList) {
}
