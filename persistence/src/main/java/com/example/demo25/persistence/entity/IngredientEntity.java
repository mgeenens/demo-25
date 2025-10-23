package com.example.demo25.persistence.entity;

import com.example.demo25.persistence.enums.Unit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "INGREDIENT")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IngredientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "QUANTITY")
    private Double quantity;

    @Enumerated(EnumType.STRING)
    @Column(name = "UNIT")
    private Unit unit;

    @ManyToOne
    @JoinColumn(name = "RECIPE_ID", nullable = false)
    private RecipeEntity recipe;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID", nullable = false)
    private ProductEntity product;
}
