package com.mombo.backend.service;

import com.mombo.backend.model.loans.LoanInstallment;
import com.mombo.backend.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class LoanServiceImpl  implements LoanService{

    @Autowired
    LoanRepository loanRepository;

    @Override
    public List<LoanInstallment> getLoanInstallments() {
        return loanRepository.getInstallments();
    }

    @Override
    public LoanInstallment saveLoanInstallment(LoanInstallment loanInstallment) {
        return loanRepository.save(loanInstallment);
    }

    @Override
    public BigDecimal calculateInstallmentAmount() {
        List<LoanInstallment> installments = new ArrayList<>();
        List<LoanInstallment> loanInstallments = new ArrayList<>();

        LoanInstallment installment1 = new LoanInstallment().setDueDate(LocalDate.now()).setAmount(BigDecimal.valueOf(9000));
        LoanInstallment installment2 = new LoanInstallment().setDueDate(LocalDate.now().plusDays(6)).setAmount(null);

        loanInstallments.add(installment1);
        loanInstallments.add(installment2);

        return loanInstallments
                .stream()
                .map(
                        LoanInstallment::getAmount
                )
                .filter(
                        Objects::nonNull
                )
                .reduce(new BigDecimal(0), (x, y) -> x.add(y));
    }
}
