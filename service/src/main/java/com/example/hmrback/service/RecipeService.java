package com.example.hmrback.service;

import com.example.hmrback.mapper.RecipeMapperImpl;
import com.example.hmrback.model.Recipe;
import com.example.hmrback.model.request.RecipeFilterRequest;
import com.example.hmrback.persistence.entity.RecipeEntity;
import com.example.hmrback.persistence.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
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

    public Page<Recipe> searchRecipes(RecipeFilterRequest filter, Pageable pageable) {
        if (filter != null) {

        }
        return Page.empty();
    }
}
