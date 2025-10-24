package com.example.demo25.mapper;

import com.example.demo25.mapper.base.BaseMapper;
import com.example.demo25.mapper.config.GlobalMapperConfig;
import com.example.demo25.model.Ingredient;
import com.example.demo25.persistence.entity.IngredientEntity;
import org.mapstruct.Mapper;

@Mapper(
    config = GlobalMapperConfig.class,
    uses = {
        ProductMapper.class
    })
public interface IngredientMapper extends BaseMapper<Ingredient, IngredientEntity> {
}
