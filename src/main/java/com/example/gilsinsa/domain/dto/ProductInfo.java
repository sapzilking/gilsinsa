package com.example.gilsinsa.domain.dto;

import com.querydsl.core.annotations.QueryProjection;

public class ProductInfo {

    public String productName;
    public int productPrice;

    @QueryProjection
    public ProductInfo(String productName, int productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }
}
