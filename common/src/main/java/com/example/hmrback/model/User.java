package com.example.hmrback.model;

public record User(Long id,
                   String firstName,
                   String lastName,
                   String email,
                   String birthDate,
                   String inscriptionDate) {
}
