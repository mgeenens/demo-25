package com.example.demo25.model;

import com.example.demo25.domain.enums.RecipeType;

public record Book(Long id, String title, String authorFullName, RecipeType recipeType, String publicationDate) {
}
