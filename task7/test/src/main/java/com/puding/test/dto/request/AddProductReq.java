package com.puding.test.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddProductReq {
    private String name;
    private String type;
    private Integer price;
    private Integer quantity;
    private Integer profitPercentage;
    private Integer taxPercentage;
    private Integer shippingCost;
}
