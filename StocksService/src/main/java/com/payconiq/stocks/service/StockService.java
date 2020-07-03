package com.payconiq.stocks.service;

import com.payconiq.stocks.dto.Stock;
import com.payconiq.stocks.dto.StockHistory;

import java.math.BigDecimal;
import java.util.List;

public interface StockService {

    Stock addStock(Stock stock);

    Stock getStock(Long stockId);

    List<Stock> getAllStocks();

    List<StockHistory> getStockHistory(Long stockId);

    Stock updatePrice(Long id, BigDecimal price);
}
