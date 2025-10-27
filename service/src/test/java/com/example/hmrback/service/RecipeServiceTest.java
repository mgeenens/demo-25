package com.example.hmrback.service;

import com.example.hmrback.BaseTest;
import com.example.hmrback.mapper.RecipeMapperImpl;
import com.example.hmrback.model.Recipe;
import com.example.hmrback.persistence.repository.RecipeRepository;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest(classes = RecipeService.class)
public class RecipeServiceTest extends BaseTest {

    @Autowired
    private RecipeService service;

    // Repo
    @MockitoBean
    private RecipeRepository repository;

    // Mapper
    @MockitoBean
    private RecipeMapperImpl mapper;

    private static Recipe recipe;

    @BeforeAll
    static void setUp() {
//        recipe = ModelTestUtils.buildRecipe(1);
    }


}
