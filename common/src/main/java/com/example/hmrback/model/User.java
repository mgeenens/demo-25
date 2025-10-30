package com.example.hmrback.model;

import com.example.hmrback.validation.ValidDate;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import static com.example.hmrback.constant.ValidationConstants.IS_REQUIRED;

public record User(Long id,

                   @JsonProperty("first_name")
                   @NotBlank(message = "First name" + IS_REQUIRED)
                   String firstName,

                   @JsonProperty("last_name")
                   @NotBlank(message = "Last name" + IS_REQUIRED)
                   String lastName,

                   @JsonProperty("username")
                   @NotBlank(message = "Username name" + IS_REQUIRED)
                   String username,

                   @NotBlank(message = "Email" + IS_REQUIRED)
                   @Email
                   String email,

                   @JsonProperty("birth_date")
                   @NotBlank(message = "Birth date" + IS_REQUIRED)
                   @ValidDate
                   String birthDate,

                   @JsonProperty("inscription_date")
                   @NotBlank(message = "Inscription date" + IS_REQUIRED)
                   @ValidDate
                   String inscriptionDate) {
}
