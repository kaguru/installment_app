package com.mombo.backend.repository;

import com.mombo.backend.model.loans.LoanInstallment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LoanRepository extends JpaRepository<LoanInstallment, Long> {
    @Query( value="SELECT * FROM loan_installments",
            nativeQuery=true)
    List<LoanInstallment> getInstallments();
}
