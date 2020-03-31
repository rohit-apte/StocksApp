package com.payconiq.stocks.dto;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Stock {
    @Id
    private Long stockId;

    @Column
    private String name;

    @Column
    private BigDecimal currentPrice;

    @Column
    private Date lastUpdate;

}
