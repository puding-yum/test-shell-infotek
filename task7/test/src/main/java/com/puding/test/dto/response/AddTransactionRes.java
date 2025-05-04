package com.puding.test.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddTransactionRes {
    private String invoice;
    private String customerEmail;
    private String paymentType;
    private String paymentCode;
    private String status;
    private String productName;
    private String productType;
    private Integer price;
    private Integer quantity;
    private Integer profitPercentage;
    private Integer taxPercentage;
    private Integer shippingCost;
    private Integer totalPrice;
    private String createdAt;
}
