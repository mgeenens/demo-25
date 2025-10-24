package com.example.demo25.mapper;

import com.example.demo25.mapper.base.BaseMapper;
import com.example.demo25.mapper.config.GlobalMapperConfig;
import com.example.demo25.model.Product;
import com.example.demo25.persistence.entity.ProductEntity;
import org.mapstruct.Mapper;

@Mapper(config = GlobalMapperConfig.class)
public interface ProductMapper extends BaseMapper<Product, ProductEntity> {
}
