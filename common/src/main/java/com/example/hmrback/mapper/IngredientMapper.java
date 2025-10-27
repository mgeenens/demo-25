package com.example.hmrback.mapper;

import com.example.hmrback.mapper.base.BaseMapper;
import com.example.hmrback.mapper.config.GlobalMapperConfig;
import com.example.hmrback.model.Ingredient;
import com.example.hmrback.persistence.entity.IngredientEntity;
import org.mapstruct.Mapper;

@Mapper(
    config = GlobalMapperConfig.class,
    uses = {
        ProductMapper.class
    })
public interface IngredientMapper extends BaseMapper<Ingredient, IngredientEntity> {
}
