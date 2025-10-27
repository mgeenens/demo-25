package com.example.demo25.mapper;

import com.example.demo25.EntityTestUtils;
import com.example.demo25.ModelTestUtils;
import com.example.demo25.model.Step;
import com.example.demo25.persistence.entity.StepEntity;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.demo25.TestConstants.NUMBER_1;
import static com.example.demo25.TestConstants.STEP_DESCRIPTION;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = { StepMapperImpl.class })
public class StepMapperTest {

    @Autowired
    private StepMapper mapper;

    private static Step model;
    private static StepEntity entity;

    @BeforeAll
    static void setUp() {
        // UserEntity
        entity = EntityTestUtils.buildStepEntity(NUMBER_1);
        // User
        model = ModelTestUtils.buildStep(NUMBER_1);
    }

    @Test
    @Order(1)
    void shouldMapEntityToModel() {
        Step result = mapper.toModel(entity);

        assertNotNull(result);
        assertEquals(NUMBER_1, result.id());
        assertEquals(STEP_DESCRIPTION.formatted(NUMBER_1), result.description());
        assertEquals(NUMBER_1.intValue(), result.order());
    }

    @Test
    @Order(2)
    void shouldMapModelToEntity() {
        StepEntity result = mapper.toEntity(model);

        assertNotNull(result);
        assertEquals(NUMBER_1, result.getId());
        assertEquals(STEP_DESCRIPTION.formatted(NUMBER_1), result.getDescription());
        assertEquals(NUMBER_1.intValue(), result.getOrder());
    }
}
