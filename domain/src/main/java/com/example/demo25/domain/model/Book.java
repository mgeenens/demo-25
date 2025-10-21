package com.example.demo25.domain.model;

import com.example.demo25.domain.enums.Genre;

public record Book(Long id, String title, Author author, Genre genre, String publicationDate) {
}
