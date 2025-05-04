package com.puding.test.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddProductRes {
    private Long id;
    private String name;
    private String type;
    private Integer price;
    private Integer quantity;
    private Integer profitPercentage;
    private Integer taxPercentage;
    private Integer shippingCost;
    private String createdAt;
    private String updatedAt;
}