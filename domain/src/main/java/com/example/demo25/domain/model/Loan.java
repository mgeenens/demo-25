package com.example.demo25.domain.model;

public record Loan(Long id, User borrower, Book book, String loanDate, String returnDate) {
}
