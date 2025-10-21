package com.example.demo25.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "LOAN")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LO_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "U_ID", nullable = false)
    private UserEntity borrower;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BK_ID", nullable = false)
    private BookEntity book;

    @Column(name = "LO_LOAN_DATE", nullable = false)
    private LocalDate loanDate;

    @Column(name = "LO_RETURN_DATE")
    private LocalDate returnDate;
}
