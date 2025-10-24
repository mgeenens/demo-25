package com.example.demo25.mapper;

import com.example.demo25.mapper.base.BaseMapper;
import com.example.demo25.mapper.config.GlobalMapperConfig;
import com.example.demo25.model.Step;
import com.example.demo25.persistence.entity.StepEntity;
import org.mapstruct.Mapper;

@Mapper(config = GlobalMapperConfig.class)
public interface StepMapper extends BaseMapper<Step, StepEntity> {
}
