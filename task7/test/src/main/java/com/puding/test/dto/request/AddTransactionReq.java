package com.puding.test.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddTransactionReq {
    private String customerEmail;
    private Long paymentTypeId;
    private Long productId;
    private Integer quantity;
}
