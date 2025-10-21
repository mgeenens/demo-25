package com.example.demo25.domain.model;

import java.time.LocalDate;

public record User(Long id, String firstName, String lastName, String email, String birthDate, String inscriptionDate) {
}
