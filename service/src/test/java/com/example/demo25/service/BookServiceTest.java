package com.example.demo25.service;

import com.example.demo25.BaseTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = RecipeService.class)
public class BookServiceTest extends BaseTest {

    @Autowired
    private RecipeService service;


}
