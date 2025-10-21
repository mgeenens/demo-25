package com.example.demo25.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USER")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "U_ID")
    private Long id;

    @Column(name = "U_FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "U_LAST_NAME", length = 100, nullable = false)
    private String lastName;

    @Column(name = "U_EMAIL", length = 150, nullable = false, unique = true)
    private String email;

    @Column(name = "U_BIRTH_DATE")
    private LocalDate birthDate;

    @Column(name = "U_INSCRIPTION_DATE")
    private LocalDate inscriptionDate;

    @OneToMany(mappedBy = "borrower", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LoanEntity> loans = new ArrayList<>();

}
