package com.example.gilsinsa.service;

import com.example.gilsinsa.domain.dto.ProductInfo;
import com.example.gilsinsa.domain.dto.ProductResponseDto;
import com.example.gilsinsa.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.gilsinsa.CommonMessage.SUCCESS_GET_PRODUCT_LIST;
import static com.example.gilsinsa.CommonValue.RESULT_SUCCESS;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponseDto getProductInfo() {
        List<ProductInfo> productInfoList = productRepository.getProductInfoList();
        return new ProductResponseDto(RESULT_SUCCESS, SUCCESS_GET_PRODUCT_LIST, productInfoList);
    }
}
