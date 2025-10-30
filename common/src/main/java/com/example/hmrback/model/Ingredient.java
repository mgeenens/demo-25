package com.example.hmrback.model;

import com.example.hmrback.persistence.enums.Unit;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import static com.example.hmrback.constant.ValidationConstants.IS_REQUIRED;
import static com.example.hmrback.constant.ValidationConstants.MUST_BE_POSITIVE;

public record Ingredient(
    Long id,

    @NotNull(message = "Quantity" + IS_REQUIRED)
    @Positive(message = "Quantity" + MUST_BE_POSITIVE)
    Double quantity,

    @NotNull(message = "Unit" + IS_REQUIRED)
    Unit unit,

    @NotNull(message = "Product" + IS_REQUIRED)
    @Valid Product product
) {}
