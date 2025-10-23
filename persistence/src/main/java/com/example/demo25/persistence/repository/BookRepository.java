package com.example.demo25.persistence.repository;

import com.example.demo25.domain.enums.RecipeType;
import com.example.demo25.persistence.entity.RecipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<RecipeEntity, Long> {

    List<RecipeEntity> findByTitleContainingIgnoreCase(String title);

    List<RecipeEntity> findByGenre(RecipeType recipeType);
}
