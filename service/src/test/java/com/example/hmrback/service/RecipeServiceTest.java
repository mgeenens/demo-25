package com.example.hmrback.service;

import com.example.hmrback.BaseTU;
import com.example.hmrback.persistence.entity.RecipeEntity;
import com.example.hmrback.utils.test.EntityTestUtils;
import com.example.hmrback.utils.test.ModelTestUtils;
import com.example.hmrback.mapper.RecipeMapperImpl;
import com.example.hmrback.model.Recipe;
import com.example.hmrback.persistence.repository.RecipeRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static com.example.hmrback.utils.test.TestConstants.NUMBER_1;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = RecipeService.class)
class RecipeServiceTest extends BaseTU {

    @Autowired
    private RecipeService service;

    // Repo
    @MockitoBean
    private RecipeRepository repository;

    // Mapper
    @MockitoBean
    private RecipeMapperImpl mapper;

    private static Recipe recipe;
    private static RecipeEntity recipeEntity;

    @BeforeAll
    static void setUp() {
        recipe = ModelTestUtils.buildRecipe(NUMBER_1, true);
        recipeEntity = EntityTestUtils.buildRecipeEntity(NUMBER_1);
    }

    @Test
    @Order(1)
    void shouldCreateRecipe() {
        when(repository.save(any(RecipeEntity.class))).thenReturn(recipeEntity);
        when(mapper.toEntity(any(Recipe.class))).thenReturn(recipeEntity);
        when(mapper.toModel(any(RecipeEntity.class))).thenReturn(recipe);

        Recipe result = service.createRecipe(recipe);

        assertNotNull(result);

        verify(repository, times(1)).save(any(RecipeEntity.class));
        verify(mapper, times(1)).toEntity(recipe);
        verify(mapper, times(1)).toModel(recipeEntity);
    }

    @Test
    @Order(2)
    void shouldSearchRecipe() { // TODO
        when(repository.save(any(RecipeEntity.class))).thenReturn(recipeEntity);
        when(mapper.toEntity(any(Recipe.class))).thenReturn(recipeEntity);
        when(mapper.toModel(any(RecipeEntity.class))).thenReturn(recipe);

        Recipe result = service.createRecipe(recipe);

        assertNotNull(result);

        verify(repository, times(1)).save(any(RecipeEntity.class));
        verify(mapper, times(1)).toEntity(recipe);
        verify(mapper, times(1)).toModel(recipeEntity);
    }

}
