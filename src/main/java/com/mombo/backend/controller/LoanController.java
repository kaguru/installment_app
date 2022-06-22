package com.mombo.backend.controller;

import com.mombo.backend.model.loans.LoanInstallment;
import com.mombo.backend.service.LoanService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/api/loan")
public class LoanController {
    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping("hello")
    private String hello() {
        return "Hello World!";
    }


    @GetMapping("installment")
    private List<LoanInstallment> getLoanInstallments() {
        return this.loanService.getLoanInstallments();
    }

    @PostMapping("installment")
    private LoanInstallment saveLoanInstallments(@RequestBody LoanInstallment loanInstallment) {
        return this.loanService.saveLoanInstallment(loanInstallment);
    }

    @GetMapping("installment/sum")
    private BigDecimal calculateInstallmentAmount() {
        return this.loanService.calculateInstallmentAmount();
    }
}
