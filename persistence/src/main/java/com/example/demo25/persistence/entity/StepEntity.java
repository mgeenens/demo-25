package com.example.demo25.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "STEP")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StepEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "DESCRIPTION", length = 2000, nullable = false)
    private String description;

    @Column(name = "ORDER", nullable = false)
    private int order;

    @ManyToOne
    @JoinColumn(name = "RECIPE_ID", nullable = false)
    private RecipeEntity recipe;
}
