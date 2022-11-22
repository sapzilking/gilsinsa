package com.example.gilsinsa.domain.dto;

import com.querydsl.core.annotations.QueryProjection;

import java.util.ArrayList;
import java.util.List;

public class ProductResponseDto extends CommonDto {
    public ProductResponseDto(boolean result, String message, List<ProductInfo> productInfoList) {
        super(result, message);
        this.productInfoList = productInfoList;
    }

    List<ProductInfo> productInfoList = new ArrayList<>();
}
