package com.example.demo25.model;

public record Loan(Long id, User borrower, Book book, String loanDate, String returnDate) {
}
