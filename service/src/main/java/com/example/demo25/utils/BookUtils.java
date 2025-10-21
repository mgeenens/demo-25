package com.example.demo25.utils;

import com.example.demo25.domain.model.Book;
import com.example.demo25.persistence.entity.BookEntity;

public class BookUtils {

    private BookUtils() {
    }

    public static Book toDTO(BookEntity entity) {
        return new Book(entity.getId(),
            entity.getTitle(),
            AuthorUtils.toDTO(entity.getAuthor()),
            entity.getGenre(),
            DateUtils.dateToddMMyyyy(entity.getPublicationDate()));
    }
}
