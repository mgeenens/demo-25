package com.example.hmrback.mapper;

import com.example.hmrback.EntityTestUtils;
import com.example.hmrback.ModelTestUtils;
import com.example.hmrback.mapper.utils.DateMapperImpl;
import com.example.hmrback.model.Recipe;
import com.example.hmrback.persistence.entity.RecipeEntity;
import com.example.hmrback.persistence.enums.RecipeType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.hmrback.TestConstants.NUMBER_1;
import static com.example.hmrback.TestConstants.RECIPE_DESCRIPTION;
import static com.example.hmrback.TestConstants.RECIPE_TITLE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = {
    RecipeMapperImpl.class,
    UserMapperImpl.class,
    IngredientMapperImpl.class,
    ProductMapperImpl.class,
    StepMapperImpl.class,
    DateMapperImpl.class
})
public class RecipeMapperTest {

    @Autowired
    private RecipeMapper mapper;

    private static Recipe model;
    private static RecipeEntity entity;

    @BeforeAll
    static void setUp() {
        // Initialize test data for Recipe and RecipeEntity
        model = ModelTestUtils.buildRecipe(NUMBER_1);

        entity = EntityTestUtils.buildRecipeEntity(NUMBER_1);
        entity.setIngredientList(EntityTestUtils.buildIngredientEntityList(5));
        entity.setStepList(EntityTestUtils.buildStepEntityList(5));
        entity.setUser(EntityTestUtils.buildUserEntity(NUMBER_1));
    }

    @Test
    @Order(1)
    void shouldMapEntityToModel() {
        Recipe result = mapper.toModel(entity);

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

    @Test
    @Order(2)
    void shouldMapModelToEntity() {
        RecipeEntity result = mapper.toEntity(model);

        assertNotNull(result);
        assertEquals(NUMBER_1, result.getId());
        assertEquals(RECIPE_TITLE.formatted(NUMBER_1), result.getTitle());
        assertEquals(RECIPE_DESCRIPTION.formatted(NUMBER_1), result.getDescription());
        assertEquals(RecipeType.ENTRY, result.getRecipeType());
        assertNotNull(result.getUser());
        assertNotNull(result.getIngredientList());
        assertFalse(result.getIngredientList().isEmpty());
        assertNotNull(result.getStepList());
        assertFalse(result.getStepList().isEmpty());
        assertEquals(40, result.getPreparationTime());
    }
}
