package com.example.demo25.mapper;

import com.example.demo25.EntityTestUtils;
import com.example.demo25.ModelTestUtils;
import com.example.demo25.model.Recipe;
import com.example.demo25.persistence.entity.RecipeEntity;
import com.example.demo25.persistence.enums.RecipeType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.demo25.TestConstants.NUMBER_1;
import static com.example.demo25.TestConstants.RECIPE_DESCRIPTION;
import static com.example.demo25.TestConstants.RECIPE_TITLE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = {
    RecipeMapperImpl.class,
    UserMapperImpl.class,
    IngredientMapperImpl.class,
    ProductMapperImpl.class,
    StepMapperImpl.class
})
public class RecipeMapperTest {

    @Autowired
    private RecipeMapper mapper;

    private static Recipe recipe;
    private static RecipeEntity recipeEntity;

    @BeforeAll
    static void setUp() {
        // Initialize test data for Recipe and RecipeEntity
        recipe = ModelTestUtils.buildRecipe(NUMBER_1);

        recipeEntity = EntityTestUtils.buildRecipeEntity(NUMBER_1);
        recipeEntity.setIngredientList(EntityTestUtils.buildIngredientEntityList(5));
        recipeEntity.setStepList(EntityTestUtils.buildStepEntityList(5));
        recipeEntity.setUser(EntityTestUtils.buildUserEntity(NUMBER_1));
    }

    @Test
    @Order(1)
    void shouldMapEntityToModel() {
        Recipe result = mapper.toModel(recipeEntity);

        assertNotNull(result);
        assertEquals(NUMBER_1, result.id());
        assertEquals(RECIPE_TITLE.formatted(NUMBER_1), result.title());
        assertEquals(RECIPE_DESCRIPTION.formatted(NUMBER_1), result.description());
        assertEquals(RecipeType.ENTRY, result.recipeType());
        assertNotNull(result.user());
        assertNotNull(result.ingredientList());
        assertFalse(result.ingredientList().isEmpty());
        assertNotNull(result.stepList());
        assertFalse(result.stepList().isEmpty());
        assertEquals(40, result.preparationTime());
    }
}
