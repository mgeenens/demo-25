package com.example.hmrback.mapper.utils;

import com.example.hmrback.mapper.config.GlobalMapperConfig;
import com.example.hmrback.utils.DateUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.time.LocalDate;

@Mapper(config = GlobalMapperConfig.class)
public interface DateMapper {

    @Named("stringToLocalDate")
    default LocalDate asLocalDate(String date) {
        return DateUtils.parseLocalDate(date);
    }

    @Named("localDateToString")
    default String asString(LocalDate date) {
        return DateUtils.formatLocalDate(date);
    }
}
