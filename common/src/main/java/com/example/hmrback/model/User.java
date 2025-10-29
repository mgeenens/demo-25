package com.example.hmrback.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record User(Long id,
                   @JsonProperty("first_name") String firstName,
                   @JsonProperty("last_name") String lastName,
                   @JsonProperty("username") String username,
                   String email,
                   @JsonProperty("birth_date") String birthDate,
                   @JsonProperty("inscription_date") String inscriptionDate) {
}
