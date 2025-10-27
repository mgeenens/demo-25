package com.example.hmrback.persistence.repository;

import com.example.hmrback.persistence.entity.RecipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface RecipeRepository extends JpaRepository<RecipeEntity, Long>, QuerydslPredicateExecutor<RecipeEntity> {

}
