package com.example.gilsinsa.repository;

import com.example.gilsinsa.domain.entity.Product;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

//@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    JPAQueryFactory queryFactory;

    @Autowired
    ProductRepository productRepository;

    @DisplayName("상품등록 및 조회 테스트")
    @Test
    void 상품등록및조회() throws Exception {
        // given
        Product pants01 = Product.builder()
                .name("black jean")
                .price(32800)
                .build();

        // when
        productRepository.save(pants01);
        Product findProduct = productRepository.findById(pants01.getSno()).get();

        // then
        assertThat(findProduct.getName()).isEqualTo(pants01.getName());
        assertThat(findProduct.getPrice()).isEqualTo(pants01.getPrice());
    }

    @DisplayName("상품삭제 테스트")
    @Test
    void 상품삭제() throws Exception {
        // given
        Product pants01 = Product.builder()
                .name("black jean")
                .price(32800)
                .build();

        // when
        productRepository.save(pants01);
        productRepository.deleteAll();

        List<Product> allProduct = productRepository.findAll();

        // then
        assertThat(allProduct.size()).isEqualTo(0);
    }

    @Commit
    @DisplayName("상품 업데이트 테스트")
    @Test
    void 상품업데이트() throws Exception {
        // given
        Product pants01 = Product.builder()
                .name("black jean")
                .price(32800)
                .build();

        // when
        productRepository.save(pants01);
        Product findProduct = productRepository.findById(pants01.getSno()).get();
        findProduct.setPrice(28000);
        Product updatedProduct = productRepository.findById(pants01.getSno()).get();

        // then
        assertThat(updatedProduct.getPrice()).isEqualTo(28000);
    }


}