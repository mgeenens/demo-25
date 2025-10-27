package com.example.hmrback.persistence.enums;

import lombok.Getter;

import java.util.List;

@Getter
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

    public static List<RecipeType> valuesList() {
        return List.of(RecipeType.values());
    }

    public static RecipeType getByIndex(int index) {
        List<RecipeType> list = valuesList();
        if (index < 0 || index >= list.size()) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for enum " + list);
        }
        return list.get(index);
    }
}
