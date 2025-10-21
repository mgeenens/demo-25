package com.example.demo25.persistence.repository;

import com.example.demo25.persistence.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
}
