package com.example.demo25.domain.enums;

public enum Unit {
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

    public String getShortName() {
        return shortName;
    }

    public String getFullName() {
        return fullName;
    }

}
