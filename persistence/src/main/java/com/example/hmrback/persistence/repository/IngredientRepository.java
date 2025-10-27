package com.example.hmrback.persistence.repository;

import com.example.hmrback.persistence.entity.IngredientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface IngredientRepository extends JpaRepository<IngredientEntity, Long>, QuerydslPredicateExecutor<IngredientEntity> {
}
