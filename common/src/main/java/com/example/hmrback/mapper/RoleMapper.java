package com.example.hmrback.mapper;

import com.example.hmrback.mapper.base.BaseMapper;
import com.example.hmrback.mapper.config.GlobalMapperConfig;
import com.example.hmrback.model.Role;
import com.example.hmrback.persistence.entity.RoleEntity;
import org.mapstruct.Mapper;

@Mapper(config = GlobalMapperConfig.class)
public interface RoleMapper extends BaseMapper<Role, RoleEntity> {
}
