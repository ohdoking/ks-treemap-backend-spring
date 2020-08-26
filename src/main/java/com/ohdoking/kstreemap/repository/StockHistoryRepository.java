package com.ohdoking.kstreemap.repository;

import com.ohdoking.kstreemap.model.StockHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

public interface StockHistoryRepository extends JpaRepository<StockHistory, UUID> {

    @Query(nativeQuery = true, value = "select * from stock_history where company_id in (select id from company where c.is_use = true and stock_market_id = :market_id) and (date = :yesterday or date = :target_date) order by company_id, date desc")
    <S extends StockHistory> List<S> findStockHistoriesByYesterdayAndTargetDay(@Param("yesterday") Date yesterday, @Param("target_date") Date targetDate);
}
