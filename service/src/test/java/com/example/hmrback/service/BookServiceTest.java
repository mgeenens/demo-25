package com.example.hmrback.service;

import com.example.hmrback.BaseTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = RecipeService.class)
public class BookServiceTest extends BaseTest {

    @Autowired
    private RecipeService service;


}
