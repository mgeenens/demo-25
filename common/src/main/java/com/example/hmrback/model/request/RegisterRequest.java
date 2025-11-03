package com.example.hmrback.model.request;

import com.example.hmrback.model.User;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

import static com.example.hmrback.constant.ValidationConstants.IS_REQUIRED;

public record RegisterRequest(
    @Valid
    User user,

    @NotBlank(message = "Password" + IS_REQUIRED)
    String password) {
}
