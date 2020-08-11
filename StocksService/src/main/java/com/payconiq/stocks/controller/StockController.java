package com.payconiq.stocks.controller;

import com.payconiq.stocks.dto.Stock;
import com.payconiq.stocks.dto.StockHistory;
import com.payconiq.stocks.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(path = "/stocks")
public class StockController {

    @Autowired
    private StockService stockService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "Alive";
    }


    @PostMapping
    public Stock addStock(@RequestBody Stock stock) {
        return stockService.addStock(stock);
    }


    @GetMapping("/{id}")
    public Stock getStock(@PathVariable Long id) {
        return stockService.getStock(id);
    }


    @PutMapping("/{id}/{price}")
    public Stock updatePrice(@PathVariable Long id, @PathVariable BigDecimal price) {
        return stockService.updatePrice(id, price);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Stock updatePriceRequestParam(@RequestParam(name = "stockId") Long id, @RequestParam(name = "price") BigDecimal price) {
        return stockService.updatePrice(id, price);
    }

    @GetMapping
    public List<Stock> getAllStocks() {
        return stockService.getAllStocks();
    }

    @GetMapping("/{id}/history")
    public List<StockHistory> getStockHistory(@PathVariable Long id) {
        return stockService.getStockHistory(id);
    }

}
