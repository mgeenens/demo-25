package com.example.demo25.persistence.repository;

import com.example.demo25.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ProductRepository extends JpaRepository<ProductEntity, Long>, QuerydslPredicateExecutor<ProductEntity> {
}
