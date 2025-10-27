package com.example.hmrback.mapper;

import com.example.hmrback.utils.EntityTestUtils;
import com.example.hmrback.utils.ModelTestUtils;
import com.example.hmrback.model.Product;
import com.example.hmrback.persistence.entity.ProductEntity;
import com.example.hmrback.persistence.enums.IngredientType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.hmrback.utils.TestConstants.NUMBER_1;
import static com.example.hmrback.utils.TestConstants.PRODUCT_NAME;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = { ProductMapperImpl.class })
public class ProductMapperTest {

    @Autowired
    private ProductMapper mapper;

    private static Product model;
    private static ProductEntity entity;

    @BeforeAll
    static void setUp() {
        // UserEntity
        entity = EntityTestUtils.buildProductEntity(NUMBER_1);
        // User
        model = ModelTestUtils.buildProduct(NUMBER_1);
    }

    @Test
    @Order(1)
    void shouldMapEntityToModel() {
        Product result = mapper.toModel(entity);

        assertNotNull(result);
        assertEquals(NUMBER_1, result.id());
        assertEquals(PRODUCT_NAME.formatted(NUMBER_1), result.name());
        assertEquals(IngredientType.getByIndex(NUMBER_1.intValue() - 1), result.ingredientType());
    }

    @Test
    @Order(2)
    void shouldMapModelToEntity() {
        ProductEntity result = mapper.toEntity(model);

        assertNotNull(result);
        assertEquals(NUMBER_1, result.getId());
        assertEquals(PRODUCT_NAME.formatted(NUMBER_1), result.getName());
        assertEquals(IngredientType.getByIndex(NUMBER_1.intValue() - 1), result.getIngredientType());
    }
}
