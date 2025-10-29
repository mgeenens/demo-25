package com.example.hmrback.predicate.builder;

import com.example.hmrback.persistence.entity.QRecipeEntity;
import com.example.hmrback.persistence.enums.RecipeType;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.util.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class RecipePredicateBuilder {

    private final QRecipeEntity recipe = QRecipeEntity.recipeEntity;
    private final List<BooleanExpression> expressions = new ArrayList<>();

    public Predicate build() {
        return expressions.stream()
            .reduce(BooleanExpression::and)
            .orElse(null);
    }

    public RecipePredicateBuilder titleContains(String title) {
        if (!StringUtils.isNullOrEmpty(title)) {
            expressions.add(recipe.title.containsIgnoreCase(title));
        }
        return this;
    }

    public RecipePredicateBuilder descriptionContains(String description) {
        if (!StringUtils.isNullOrEmpty(description)) {
            expressions.add(recipe.description.containsIgnoreCase(description));
        }
        return this;
    }

    public RecipePredicateBuilder maxPrepTime(Integer maxPrepTime) {
        if (maxPrepTime != null) {
            expressions.add(recipe.preparationTime.loe(maxPrepTime));
        }
        return this;
    }

    public RecipePredicateBuilder recipeTypeIn(List<RecipeType> typeList) {
        if (!CollectionUtils.isEmpty(typeList)) {
            expressions.add(recipe.recipeType.in(typeList));
        }
        return this;
    }
}
