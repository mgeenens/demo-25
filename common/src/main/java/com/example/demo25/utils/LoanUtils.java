package com.example.demo25.utils;

import com.example.demo25.domain.model.Loan;

public class LoanUtils {

    private LoanUtils() {
    }

    public static Loan toDTO(LoanEntity loanEntity) {
        return new Loan(
            loanEntity.getId(),
            UserUtils.toDTO(loanEntity.getBorrower()),
            BookUtils.toDTO(loanEntity.getBook()),
            DateUtils.dateToddMMyyyy(loanEntity.getLoanDate()),
            DateUtils.dateToddMMyyyy(loanEntity.getReturnDate())
        );
    }
}
