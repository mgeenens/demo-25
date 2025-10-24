package com.example.demo25.mapper.base;

import org.mapstruct.MappingTarget;

public interface BaseMapper<D, E> {
    D toModel(E entity);

    E toEntity(D model);

    void updateEntityFromModel(D model,
        @MappingTarget
        E entity);
}
