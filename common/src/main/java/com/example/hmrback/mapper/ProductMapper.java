package com.example.hmrback.mapper;

import com.example.hmrback.mapper.base.BaseMapper;
import com.example.hmrback.mapper.config.GlobalMapperConfig;
import com.example.hmrback.model.Product;
import com.example.hmrback.persistence.entity.ProductEntity;
import org.mapstruct.Mapper;

@Mapper(config = GlobalMapperConfig.class)
public interface ProductMapper extends BaseMapper<Product, ProductEntity> {
}
