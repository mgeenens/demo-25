package com.example.demo25.persistence.enums;

import lombok.Getter;

import java.util.List;

@Getter
public enum RecipeType implements IndexedEnum<RecipeType> {
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

    @Override
    public List<RecipeType> valuesList() {
        return List.of(RecipeType.values());
    }
}
