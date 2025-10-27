package com.example.demo25.mapper;

import com.example.demo25.mapper.base.BaseMapper;
import com.example.demo25.mapper.config.GlobalMapperConfig;
import com.example.demo25.mapper.utils.DateMapper;
import com.example.demo25.model.User;
import com.example.demo25.persistence.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(
    config = GlobalMapperConfig.class,
    uses =  DateMapper.class
)
public interface UserMapper extends BaseMapper<User, UserEntity> {

    @Override
    @Mappings({
        @Mapping(source = "birthDate", target = "birthDate", qualifiedByName = "localDateToString"),
        @Mapping(source = "inscriptionDate", target = "inscriptionDate", qualifiedByName = "localDateToString")
    })
    User toModel(UserEntity entity);

    @Override

    @Mappings({
        @Mapping(source = "birthDate", target = "birthDate", qualifiedByName = "stringToLocalDate"),
        @Mapping(source = "inscriptionDate", target = "inscriptionDate", qualifiedByName = "stringToLocalDate")
    })
    UserEntity toEntity(User model);
}
