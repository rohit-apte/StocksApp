package com.payconiq.stocks.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.payconiq.stocks.dto.Stock;
import com.payconiq.stocks.service.StockServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class StockConfig {
    private static Logger LOG = LoggerFactory.getLogger("CarAppConfig");
    @Autowired
    private StockServiceImpl stockService;

    @Bean
    public List<Stock> savestockDetails() {
        List<Stock> stocks = new ArrayList<>();
        try {
            String data = Files.readString(Path.of("src/main/resources/StockData.json"));
            ObjectMapper mapper = new ObjectMapper();
            List<Stock> stockData = mapper.readValue(data, new TypeReference<List<Stock>>() {
            });
            stockService.addAllStocks(stockData);
        } catch (FileNotFoundException e) {
            LOG.error("Stock Data File not found at given path.");
        } catch (IOException e) {
            LOG.error("Unable to load data from file");
        }
        return stocks;
    }
}
