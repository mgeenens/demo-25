package com.example.demo25.mapper;

import com.example.demo25.model.Recipe;
import com.example.demo25.persistence.entity.RecipeEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RecipeMapper {

    Recipe toModel(RecipeEntity entity);

    RecipeEntity toEntity(Recipe model);

    List<Recipe> toModelList(List<RecipeEntity> entities);
}
