package com.bahia.demo.precio;

import lombok.Data;
import com.bahia.demo.brand.Brand;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
public class Precio {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "brand")
    private Brand brand;


    @NotNull
    @Column(name = "start_date", columnDefinition = "TIMESTAMP")
    private LocalDateTime startDate;

    @NotNull
    @Column(name = "end_date", columnDefinition = "TIMESTAMP")
    private LocalDateTime endDate;


    @Positive
    @Column(name = "price_list")
    private Long priceList;


    @Positive
    @Column(name = "product_id")
    private Long productId;

    @Positive
    @Column(name = "priority")
    private Integer priority;

    @Positive
    @NotNull
    private BigDecimal price;

    @NotNull
    @Column(name = "curr")
    private String curr;


    @NotNull
    @Column(name = "created_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;

    @NotNull
    @Column(name = "updated_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void prePersist() {
        if (this.createdAt == null) createdAt = LocalDateTime.now();
        if (this.updatedAt == null) updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
