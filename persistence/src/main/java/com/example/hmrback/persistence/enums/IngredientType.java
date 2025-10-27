package com.example.hmrback.persistence.enums;

import lombok.Getter;

import java.util.List;

@Getter
public enum IngredientType {
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

    public static List<IngredientType> valuesList() {
        return List.of(IngredientType.values());
    }

    public static IngredientType getByIndex(int index) {
        List<IngredientType> list = valuesList();
        if (index < 0 || index >= list.size()) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for enum " + list);
        }
        return list.get(index);
    }
}
