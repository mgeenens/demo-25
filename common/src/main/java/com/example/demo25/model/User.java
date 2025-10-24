package com.example.demo25.model;

public record User(Long id,
                   String firstName,
                   String lastName,
                   String email,
                   String birthDate,
                   String inscriptionDate) {
}
