package com.example.demo25.persistence.enums;

public enum RecipeType {
    ENTRY("Entrée"),
    MAIN_COURSE("Plat principal"),
    DESSERT("Dessert"),
    BEVERAGE("Boisson"),
    SNACK("Snack"),
    APPETIZER("Apéritif"),
    SIDE_DISH("Accompagnement");

    private final String typeName;

    RecipeType(String type) {
        this.typeName = type;
    }

    public String getTypeName() {
        return typeName;
    }
}
