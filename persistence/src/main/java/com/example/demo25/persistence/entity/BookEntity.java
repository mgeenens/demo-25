package com.example.demo25.persistence.entity;

import com.example.demo25.domain.enums.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "BOOK")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BK_ID")
    private Long id;

    @Column(name = "BK_TITLE", nullable = false)
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(name = "BK_GENRE", length = 50, nullable = false)
    private Genre genre;

    @Column(name = "BK_PUBLICATION_DATE")
    private LocalDate publicationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AU_ID", nullable = false)
    private AuthorEntity author;
}
