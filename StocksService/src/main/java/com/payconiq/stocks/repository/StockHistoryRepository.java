package com.payconiq.stocks.repository;

import com.payconiq.stocks.dto.StockHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockHistoryRepository extends JpaRepository<StockHistory, Integer> {

}
