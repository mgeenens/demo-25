package com.example.hmrback.model;

import com.example.hmrback.persistence.enums.RecipeType;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record Recipe(Long id,
                     String title,
                     String description,
                     @JsonProperty("preparation_time")
                     Integer preparationTime,
                     @JsonProperty("recipe_type")
                     RecipeType recipeType,
                     @JsonProperty("publication_date")
                     String publicationDate,
                     User author,
                     @JsonProperty("ingredient_list")
                     List<Ingredient> ingredientList,
                     @JsonProperty("step_list")
                     List<Step> stepList) {
}
