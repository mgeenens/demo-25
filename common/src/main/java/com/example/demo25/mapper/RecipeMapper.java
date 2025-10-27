package com.example.demo25.mapper;

import com.example.demo25.mapper.base.BaseMapper;
import com.example.demo25.mapper.config.GlobalMapperConfig;
import com.example.demo25.mapper.utils.DateMapper;
import com.example.demo25.model.Recipe;
import com.example.demo25.persistence.entity.RecipeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(
    config = GlobalMapperConfig.class,
    uses = {
        IngredientMapper.class,
        StepMapper.class,
        UserMapper.class,
        DateMapper.class
    })
public interface RecipeMapper extends BaseMapper<Recipe, RecipeEntity> {

    @Override
    @Mapping(source = "publicationDate", target = "publicationDate", qualifiedByName = "localDateToString")
    Recipe toModel(RecipeEntity entity);

    @Override
    @Mapping(source = "publicationDate", target = "publicationDate", qualifiedByName = "stringToLocalDate")
    RecipeEntity toEntity(Recipe model);

    List<Recipe> toModelList(List<RecipeEntity> entities);
}
