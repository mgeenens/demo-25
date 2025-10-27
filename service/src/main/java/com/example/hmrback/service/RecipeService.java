package com.example.hmrback.service;

import com.example.hmrback.mapper.RecipeMapperImpl;
import com.example.hmrback.model.Recipe;
import com.example.hmrback.persistence.entity.RecipeEntity;
import com.example.hmrback.persistence.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {

    // Repo
    private final RecipeRepository recipeRepository;

    // Mapper
    private final RecipeMapperImpl recipeMapper;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository, RecipeMapperImpl recipeMapper) {
        this.recipeRepository = recipeRepository;
        this.recipeMapper = recipeMapper;
    }

    public Recipe createRecipe(Recipe recipe) {
        RecipeEntity recipeEntity = recipeMapper.toEntity(recipe);
        return recipeMapper.toModel(recipeRepository.save(recipeEntity));
    }
}
