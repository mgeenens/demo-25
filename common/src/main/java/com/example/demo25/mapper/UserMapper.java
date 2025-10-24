package com.example.demo25.mapper;

import com.example.demo25.mapper.base.BaseMapper;
import com.example.demo25.mapper.config.GlobalMapperConfig;
import com.example.demo25.model.User;
import com.example.demo25.persistence.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(config = GlobalMapperConfig.class)
public interface UserMapper extends BaseMapper<User, UserEntity> {
}
