package com.example.gilsinsa.domain.entity;

import lombok.Builder;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Entity
public class Product {

    public Product() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long sno; // 상품 테이블 PK

    private String name; // 상품명

    private int price; // 상품 가격

//    @Lob
//    private byte[] image; // 상품 이미지


    public long getSno() {
        return sno;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Builder
    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
