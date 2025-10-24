package com.example.demo25;

import com.example.demo25.persistence.entity.ProductEntity;
import com.example.demo25.persistence.entity.UserEntity;
import com.example.demo25.persistence.enums.IngredientType;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.LongStream;

public class TestUtils {

    public static final Long NUMBER_1 = 1L;

    private TestUtils() {
    }

    /**
     * Builds a UserEntity instance for testing purposes.
     * <ul>
     *     <li>Id: ordinal</li>
     *     <li>First Name: "fName" + ordinal</li>
     *     <li>Last Name: "lName" + ordinal</li>
     *     <li>Email: "email" + ordinal + "@test.com"</li>
     *     <li>Birth Date: Current date minus (10 * ordinal) years</li>
     *     <li>Inscription Date: Current date minus ordinal months</li>
     * </ul>
     *
     * @param ordinal the position number to differentiate users
     * @return UserEntity instance
     */
    public static UserEntity buildUserEntity(Long ordinal) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(ordinal);
        userEntity.setFirstName("fName" + ordinal);
        userEntity.setLastName("lName" + ordinal);
        userEntity.setEmail("email" + ordinal + "@test.com");
        userEntity.setBirthDate(LocalDate.now().minusYears(10 * ordinal));
        userEntity.setInscriptionDate(LocalDate.now().minusMonths(ordinal));
        return userEntity;
    }

    /**
     * Builds a list of UserEntity instances for testing purposes.
     *
     * @param count the number of UserEntity instances to create
     * @return List of UserEntity instances
     */
    public static List<UserEntity> buildUserEntityList(int count) {
        return LongStream.rangeClosed(1, count)
            .mapToObj(TestUtils::buildUserEntity)
            .toList();
    }

    public static ProductEntity buildProductEntity(Long ordinal) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(ordinal);
        productEntity.setName("Product" + ordinal);
        productEntity.setIngredientType(IngredientType.MEAT);
        return productEntity;
    }
}
