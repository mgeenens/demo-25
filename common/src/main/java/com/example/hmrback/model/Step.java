package com.example.hmrback.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import static com.example.hmrback.constant.ValidationConstants.IS_REQUIRED;
import static com.example.hmrback.constant.ValidationConstants.MUST_BE_POSITIVE;

public record Step(
    Long id,

    @NotBlank(message = "Description" + IS_REQUIRED)
    String description,

    @NotNull(message = "Order" + IS_REQUIRED)
    @Positive(message = "Order" + MUST_BE_POSITIVE)
    Integer order
) {}
