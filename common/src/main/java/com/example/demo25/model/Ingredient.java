package com.example.demo25.model;

import com.example.demo25.persistence.enums.Unit;

public record Ingredient(
    Long id,
    Double quantity,
    Unit unit,
    Product product
) {}
