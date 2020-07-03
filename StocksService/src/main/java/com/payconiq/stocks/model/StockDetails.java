package com.payconiq.stocks.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
public class StockDetails {
    private Long stockId;
    private Date lastUpdate;
    private String stockName;
    private BigDecimal currentPrice;
}
