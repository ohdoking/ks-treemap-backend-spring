package com.ohdoking.kstreemap.repository;

import com.ohdoking.kstreemap.model.StockHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StockHistoryRepository extends JpaRepository<StockHistory, UUID> {
}
