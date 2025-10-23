package com.example.demo25.persistence.repository;

import com.example.demo25.domain.enums.Genre;
import com.example.demo25.persistence.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, Long> {

    List<BookEntity> findByTitleContainingIgnoreCase(String title);

    List<BookEntity> findByGenre(Genre genre);
}
