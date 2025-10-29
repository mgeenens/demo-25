package com.example.hmrback.model.request;

import com.example.hmrback.persistence.enums.IngredientType;
import com.example.hmrback.persistence.enums.RecipeType;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record RecipeFilterRequest(String title,
                                  String description,
                                  @JsonProperty("maximum_preparation_time")
                                  Integer maximumPreparationTime,
                                  @JsonProperty("recipe_type_list")
                                  List<RecipeType> recipeTypeList,
                                  String author,
                                  @JsonProperty("ingredient_name_list")
                                  List<String> ingredientNameList,
                                    @JsonProperty("ingredient_type_list")
                                  List<IngredientType> ingredientTypeList) {
}