package com.puding.test.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "PRODUCT")
@Getter
@Setter
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "TYPE", nullable = false)
    private String type;

    @Column(name = "PRICE", nullable = false)
    private Integer price;

    @Column(name = "QUANTITY", nullable = false)
    private Integer quantity;

    @Column(name = "PROFIT_PERCENTAGE", nullable = false)
    private Integer profitPercentage;

    @Column(name = "TAX_PERCENTAGE", nullable = false)
    private Integer taxPercentage;

    @Column(name = "SHIPPING_COST", nullable = false)
    private Integer shippingCost;

    @Column(name = "CREATED_AT", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "UPDATED_AT")
    private LocalDateTime updatedAt;

    @Column(name = "DELETED_AT")
    private LocalDateTime deletedAt;
}