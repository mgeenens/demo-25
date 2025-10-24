package com.example.demo25.mapper;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

public class RecipeMapperTest {

    private final RecipeMapper mapper = Mappers.getMapper(RecipeMapper.class);

    @Test
    @Order(1)
    void shouldMapEntityToModel() {

    }
}
