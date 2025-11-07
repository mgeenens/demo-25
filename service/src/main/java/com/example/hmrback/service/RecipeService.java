package com.example.hmrback.service;

import com.example.hmrback.mapper.RecipeMapperImpl;
import com.example.hmrback.model.Recipe;
import com.example.hmrback.model.request.RecipeFilter;
import com.example.hmrback.persistence.entity.RecipeEntity;
import com.example.hmrback.persistence.repository.RecipeRepository;
import com.example.hmrback.predicate.factory.RecipePredicateFactory;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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

    public Page<Recipe> searchRecipes(RecipeFilter filter, Pageable pageable) {
        if (filter != null) {
            return recipeRepository.findAll(RecipePredicateFactory.fromFilters(filter), pageable).map(recipeMapper::toModel);
        }
        return Page.empty();
    }

    @Transactional
    public Recipe updateRecipe(
        @NotNull
        Long recipeId,
        @Valid
        Recipe recipe) {
        return recipeMapper.toModel(recipeRepository.saveAndFlush(recipeMapper.toEntity(recipe)));
    }

    @Transactional
    public void deleteRecipe(
        @NotNull
        Long id) {
        Optional<RecipeEntity> recipeEntity = recipeRepository.findById(id);
        recipeEntity.ifPresentOrElse(recipeRepository::delete, () -> {
            throw new EntityNotFoundException("Recipe with id %s not found".formatted(id));
        });
    }
}
