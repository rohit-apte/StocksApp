package com.payconiq.stocks.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
public class StockHistoryDetails {
    private Long stockId;
    private String name;
    private BigDecimal cost;
    private Date updated;
}
