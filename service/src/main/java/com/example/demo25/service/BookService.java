package com.example.demo25.service;

import com.example.demo25.domain.model.Book;
import com.example.demo25.persistence.repository.BookRepository;
import com.example.demo25.utils.BookUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll().stream()
            .map(BookUtils::toDTO)
            .toList();
    }
}
