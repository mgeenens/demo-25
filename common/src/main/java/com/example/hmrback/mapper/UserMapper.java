package com.example.hmrback.mapper;

import com.example.hmrback.mapper.base.BaseMapper;
import com.example.hmrback.mapper.config.GlobalMapperConfig;
import com.example.hmrback.mapper.utils.DateMapper;
import com.example.hmrback.model.User;
import com.example.hmrback.persistence.entity.UserEntity;
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
