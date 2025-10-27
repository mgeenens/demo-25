package com.example.hmrback.model;

import com.example.hmrback.persistence.enums.Unit;

public record Ingredient(
    Long id,
    Double quantity,
    Unit unit,
    Product product
) {}
