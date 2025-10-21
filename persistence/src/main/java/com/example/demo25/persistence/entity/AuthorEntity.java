package com.example.demo25.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "AUTHOR")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AU_ID")
    private Long id;

    @Column(name = "AU_FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "AU_LAST_NAME", nullable = false)
    private String lastName;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BookEntity> books = new ArrayList<>();

}
