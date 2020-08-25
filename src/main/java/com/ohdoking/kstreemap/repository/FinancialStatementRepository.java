package com.ohdoking.kstreemap.repository;

import com.ohdoking.kstreemap.model.Company;
import com.ohdoking.kstreemap.model.FinancialStatement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FinancialStatementRepository extends JpaRepository<FinancialStatement, UUID> {
}
