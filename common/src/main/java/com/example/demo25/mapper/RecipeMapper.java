package com.example.demo25.mapper;

import com.example.demo25.mapper.base.BaseMapper;
import com.example.demo25.mapper.config.GlobalMapperConfig;
import com.example.demo25.model.Recipe;
import com.example.demo25.persistence.entity.RecipeEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(
    config = GlobalMapperConfig.class,
    uses = {
        IngredientMapper.class,
        StepMapper.class,
        UserMapper.class
    })
public interface RecipeMapper extends BaseMapper<Recipe, RecipeEntity> {

    List<Recipe> toModelList(List<RecipeEntity> entities);
}
