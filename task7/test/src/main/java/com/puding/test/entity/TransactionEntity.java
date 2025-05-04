package com.puding.test.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "TRANSACTION")
@Getter
@Setter
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "INVOICE", nullable = false, unique = true)
    private String invoice;

    @Column(name = "CUSTOMER_EMAIL", nullable = false)
    private String customerEmail;

    @Column(name = "PAYMENT_TYPE_ID", nullable = false)
    private Long paymentTypeId;

    @Column(name = "PAYMENT_CODE", nullable = false)
    private String paymentCode;

    @Column(name = "STATUS", nullable = false)
    private String status;

    @Column(name = "PRODUCT_ID", nullable = false)
    private Long productId;

    @Column(name = "PRODUCT_NAME", nullable = false)
    private String productName;

    @Column(name = "PRODUCT_TYPE", nullable = false)
    private String productType;

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
