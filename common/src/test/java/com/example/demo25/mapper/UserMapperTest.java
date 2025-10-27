package com.example.demo25.mapper;

import com.example.demo25.EntityTestUtils;
import com.example.demo25.ModelTestUtils;
import com.example.demo25.mapper.utils.DateMapperImpl;
import com.example.demo25.model.User;
import com.example.demo25.persistence.entity.UserEntity;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.demo25.TestConstants.EMAIL;
import static com.example.demo25.TestConstants.FIRST_NAME;
import static com.example.demo25.TestConstants.LAST_NAME;
import static com.example.demo25.TestConstants.NUMBER_1;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = {
    UserMapperImpl.class,
    DateMapperImpl.class
})
public class UserMapperTest {

    @Autowired
    private UserMapper mapper;

    private static User model;
    private static UserEntity entity;

    @BeforeAll
    static void setUp() {
        // UserEntity
        entity = EntityTestUtils.buildUserEntity(NUMBER_1);
        // User
        model = ModelTestUtils.buildUser(NUMBER_1);
    }

    @Test
    @Order(1)
    void shouldMapEntityToModel() {
        User result = mapper.toModel(entity);

        assertNotNull(result);
        assertEquals(NUMBER_1, result.id());
        assertEquals(FIRST_NAME.formatted(NUMBER_1), result.firstName());
        assertEquals(LAST_NAME.formatted(NUMBER_1), result.lastName());
        assertEquals(EMAIL.formatted(NUMBER_1), result.email());
    }

    @Test
    @Order(2)
    void shouldMapModelToEntity() {
        UserEntity result = mapper.toEntity(model);

        assertNotNull(result);
        assertEquals(NUMBER_1, result.getId());
        assertEquals(FIRST_NAME.formatted(NUMBER_1), result.getFirstName());
        assertEquals(LAST_NAME.formatted(NUMBER_1), result.getLastName());
        assertEquals(EMAIL.formatted(NUMBER_1), result.getEmail());
    }
}
