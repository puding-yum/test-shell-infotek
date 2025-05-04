package com.puding.test.dao;

public interface TransactionDao {
    Long getProductId();
    String getProductName();
    String getProductType();
    Integer getPrice();
    Integer getQuantity();
    Integer getProfitPercentage();
}