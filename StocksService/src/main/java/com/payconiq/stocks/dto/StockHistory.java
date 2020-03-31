package com.payconiq.stocks.dto;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
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
public class StockHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private Long stockId;

    @Column
    private String stockName;

    @Column
    private BigDecimal price;

    @Column(updatable = false)
    @CreationTimestamp
    private Date created;

}
