package com.payconiq.stocks.service;

import com.payconiq.stocks.dto.Stock;
import com.payconiq.stocks.repository.StockHistoryRepository;
import com.payconiq.stocks.repository.StockRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class StockServiceImplTest {

    @InjectMocks
    private StockServiceImpl stockService;

    @Mock
    private StockRepository stockRepo;

    @Mock
    private StockHistoryRepository stockHistoryRepo;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        Stock stock1 = Stock.builder().stockId(500L).name("Stock1").currentPrice(new BigDecimal(1.50)).build();
        Stock stock2 = Stock.builder().stockId(501L).name("Stock2").currentPrice(new BigDecimal(2.50)).build();
        List<Stock> stocks = new ArrayList<>(2);
        stocks.add(stock1);
        stocks.add(stock2);
        Mockito.when(stockRepo.findAll()).thenReturn(stocks);
    }

    @Test
    public void addStockTest() {
        Stock stock = Stock.builder().stockId(1L).stockId(100L).lastUpdate(new Date()).build();
        Mockito.when(stockRepo.save(Mockito.any())).thenReturn(stock);
        assertEquals(Long.valueOf(100), stockService.addStock(stock).getStockId());
    }

    @Test
    public void getStockTest() {
        Stock stock = Stock.builder().stockId(1L).lastUpdate(new Date()).name("Stock A").build();
        Mockito.when(stockRepo.findById(Mockito.anyLong())).thenReturn(java.util.Optional.ofNullable(stock));
        assertEquals("Stock A", stockService.getStock(1L).getName());
    }


    @Test
    public void getAllStocksTest() {

        assertNotNull(stockService.getAllStocks());
    }

    @Test
    public void updatePriceTest() {
        Stock stock = Stock.builder().stockId(10L).name("Stock1").currentPrice(BigDecimal.valueOf(50.00)).build();
        Mockito.when(stockRepo.findById(Mockito.anyLong())).thenReturn(Optional.of(stock));
        Mockito.when(stockRepo.save(Mockito.any())).thenReturn(stock);
        assertEquals(BigDecimal.valueOf(65.00), stockService.updatePrice(10L, BigDecimal.valueOf(65.00)).getCurrentPrice());
    }


    @Test
    public void getStockHistoryTest() {
        assertNotNull(stockService.getStockHistory(10L));
    }
}
