package com.example.demo25.persistence.repository;

import com.example.demo25.persistence.entity.IngredientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface IngredientRepository extends JpaRepository<IngredientEntity, Long>, QuerydslPredicateExecutor<IngredientEntity> {
}
