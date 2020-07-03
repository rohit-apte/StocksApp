package com.payconiq.stocks.service;

import com.payconiq.stocks.dto.Stock;
import com.payconiq.stocks.dto.StockHistory;
import com.payconiq.stocks.repository.StockHistoryRepository;
import com.payconiq.stocks.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * Business logic for Stock Service Application is written in this class.
 */
@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepository stockRepo;

    @Autowired
    private StockHistoryRepository stockHistoryRepo;

    /**
     * Takes Stock details as input and add that Stock to database and also makes an entry to history table.
     *
     * @param stock - input stock details
     * @return - Saved Stock Object.
     */
    public Stock addStock(Stock stock) {
        Stock savedStock = stockRepo.save(stock);
        StockHistory stockHistory = StockHistory.builder().stockId(stock.getStockId()).price(stock.getCurrentPrice()).stockName(stock.getName()).build();
        stockHistoryRepo.save(stockHistory);
        return savedStock;
    }

    /**
     * Add multiple Stock Details and makes new entry in history table
     *
     * @param stocks - list of stock to be added in database
     */
    public void addAllStocks(List<Stock> stocks) {
        stockRepo.saveAll(stocks);
        stocks.forEach(stock -> {
            StockHistory stockHistory = StockHistory.builder().stockId(stock.getStockId()).price(stock.getCurrentPrice()).stockName(stock.getName()).build();
            stockHistoryRepo.save(stockHistory);
        });
    }

    /**
     * Takes Stock id as input and returns Stock details.
     *
     * @param stockId - input Stock Id
     * @return Stock details
     */
    public Stock getStock(Long stockId) {
        return stockRepo.findById(stockId).orElse(null);
    }

    /**
     * Finds all the stocks present in database
     *
     * @return list of all the stocks available in stock table
     */
    @Override
    public List<Stock> getAllStocks() {
        return stockRepo.findAll();
    }

    /**
     * Gets complete history of stock sorted by created date ascending
     *
     * @param stockId Stock id
     * @return List of stock history
     */
    @Override
    public List<StockHistory> getStockHistory(Long stockId) {
        StockHistory stockHistory = StockHistory.builder().stockId(stockId).build();
        Example example = Example.of(stockHistory);
        return stockHistoryRepo.findAll(example, Sort.by("created"));
    }

    /**
     * Updates the stock price for given stock id
     *
     * @param id    - Stock Id
     * @param price - New Price of the stock
     * @return - Updated stock object
     */
    @Override
    public Stock updatePrice(Long id, BigDecimal price) {
        Optional<Stock> stock = stockRepo.findById(id);
        Stock updateStock = null;
        if (stock.isPresent()) {
            updateStock = stock.get();
            updateStock.setCurrentPrice(price);
            updateStock = addStock(updateStock);
        }
        return updateStock;
    }
}
