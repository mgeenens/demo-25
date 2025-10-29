package com.example.hmrback.predicate.factory;

import com.example.hmrback.model.request.RecipeFilter;
import com.example.hmrback.predicate.builder.RecipePredicateBuilder;
import com.querydsl.core.types.Predicate;

public class RecipePredicateFactory {

    private RecipePredicateFactory() {
    }

    public static Predicate fromFilters(RecipeFilter filters) {
        return new RecipePredicateBuilder()
            .titleContains(filters.title())
            .descriptionContains(filters.description())
            .maxPrepTime(filters.maximumPreparationTime())
            .recipeTypeIn(filters.recipeTypeList())
            .authorUsernameContains(filters.authorUsername())
            .ingredientNameIn(filters.ingredientNameList())
            .ingrendientTypeIn(filters.ingredientTypeList())
            .build();
    }
}
