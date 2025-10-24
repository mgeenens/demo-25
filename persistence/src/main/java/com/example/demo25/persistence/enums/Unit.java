package com.example.demo25.persistence.enums;

import lombok.Getter;

import java.util.List;

@Getter
public enum Unit implements IndexedEnum<Unit>{
    // TODO: improve with unit type (weight, volume, count, etc.)
    GRAM("g", "Gramme"),
    KILOGRAM("kg", "Kilogramme"),
    LITER("L", "Litre"),
    MILLILITER("mL", "Millilitre"),
    CUP("t.", "Tasse"),
    TABLESPOON("c.a.s.", "Cuillère à soupe"),
    TEASPOON("c.a.c.", "Cuillère à café"),
    PIECE("pc", "Pièce");

    private final String shortName;
    private final String fullName;

    Unit(String shortName, String fullName) {
        this.shortName = shortName;
        this.fullName = fullName;
    }

    @Override
    public List<Unit> valuesList() {
        return List.of(Unit.values());
    }
}
