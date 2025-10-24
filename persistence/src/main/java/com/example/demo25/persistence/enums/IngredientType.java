package com.example.demo25.persistence.enums;

import lombok.Getter;

import java.util.List;

@Getter
public enum IngredientType implements IndexedEnum<IngredientType> {
    VEGETABLE("Légume"),
    FRUIT("Fruit"),
    MEAT("Viande"),
    FISH("Poisson"),
    DAIRY("Produit laitier"),
    GRAIN("Céréale"),
    SPICE("Épice"),
    OTHER("Autre");

    private final String typeName;

    IngredientType(String type) {
        this.typeName = type;
    }

    @Override
    public List<IngredientType> valuesList() {
        return List.of(IngredientType.values());
    }
}
