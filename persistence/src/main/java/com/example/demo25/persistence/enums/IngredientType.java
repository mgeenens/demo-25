package com.example.demo25.persistence.enums;

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

    public String getTypeName() {
        return typeName;
    }
}
