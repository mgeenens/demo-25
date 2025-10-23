package com.example.demo25.utils;

import com.example.demo25.domain.model.Book;
import com.example.demo25.persistence.entity.RecipeEntity;

public class BookUtils {

    private BookUtils() {
    }

    public static Book toDTO(RecipeEntity entity) {
        return new Book(entity.getId(),
            entity.getTitle(),
            AuthorUtils.buildAuthorFullname(entity.getAuthor()),
            entity.getRecipeType(),
            DateUtils.dateToddMMyyyy(entity.getPublicationDate()));
    }
}
