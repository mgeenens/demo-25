package com.example.hmrback.utils.test;

import com.example.hmrback.model.request.RecipeFilter;
import com.example.hmrback.persistence.enums.IngredientType;
import com.example.hmrback.persistence.enums.RecipeType;

import java.util.List;

public class CommonTestUtils {

    private CommonTestUtils() {
    }

    public static RecipeFilter buildRecipeFilter() {
        return new RecipeFilter(
            "Spaghetti",
            "Delicious homemade spaghetti",
            30,
            List.of(RecipeType.MAIN_COURSE),
            "chef123",
            List.of("Tomato", "Basil"),
            List.of(IngredientType.MEAT)
        );
    }
}
