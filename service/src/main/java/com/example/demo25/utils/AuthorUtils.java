package com.example.demo25.utils;

import com.example.demo25.domain.model.Author;
import com.example.demo25.persistence.entity.AuthorEntity;

public class AuthorUtils {

    private AuthorUtils() {
    }

    public static Author toDTO(AuthorEntity entity) {
        return new Author(
                entity.getId(),
                entity.getFirstName(),
                entity.getLastName()
        );
    }
}
