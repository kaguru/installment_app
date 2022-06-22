package com.mombo.backend.service;

import com.mombo.backend.model.loans.LoanInstallment;

import java.math.BigDecimal;
import java.util.List;

public interface LoanService {
    public List<LoanInstallment> getLoanInstallments();
    public LoanInstallment saveLoanInstallment(LoanInstallment loanInstallment);
    public BigDecimal calculateInstallmentAmount();
}
