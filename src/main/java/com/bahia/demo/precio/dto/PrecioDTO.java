package com.bahia.demo.precio.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class PrecioDTO {
    private String brandName;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    @Positive
    private Long priceList;

    @Positive
    private Long productId;

    @Positive
    private BigDecimal price;

    private String curr;

}
