package com.example.demo25.service;

import com.example.demo25.BaseTest;
import com.example.demo25.persistence.entity.BookEntity;
import com.example.demo25.persistence.repository.BookRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.mockito.Mockito.*;
import java.util.List;

@SpringBootTest(classes = BookService.class)
public class BookServiceTest extends BaseTest {

    @Autowired
    private BookService service;

    @MockitoBean
    private BookRepository bookRepository;

    private static List<BookEntity> bookList;

    @BeforeAll
    static void setUp() {
    }

    @Test
    @Order(1)
    void getAllBooks() {
        when(bookRepository.findAll()).thenReturn(bookList);
    }

}
