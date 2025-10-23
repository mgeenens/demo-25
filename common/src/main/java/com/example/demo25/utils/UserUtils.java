package com.example.demo25.utils;

import com.example.demo25.model.User;
import com.example.demo25.persistence.entity.UserEntity;

public class UserUtils {

    private UserUtils() {
    }

    public static User toDTO(UserEntity userEntity) {
        return new User(userEntity.getId(),
            userEntity.getFirstName(),
            userEntity.getLastName(),
            userEntity.getEmail(),
            DateUtils.dateToddMMyyyy(userEntity.getBirthDate()),
            DateUtils.dateToddMMyyyy(userEntity.getInscriptionDate()));
    }
}
