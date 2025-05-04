package com.puding.test.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ReportRes {
    private List<Transaction> transactions;

    @Getter
    @Setter
    public static class Transaction {
        private int no;
        private Long productId;
        private String productName;
        private String productType;
        private Integer price;
        private Integer quantity;
        private Integer profitPercentage;
        private Integer totalProfit;
    }
}
