package com.project.basicshop.web.dto;

import com.project.basicshop.domain.product.Product;

public class ProductListResponseDto {
    private Long productId;
    private String name;
    private String company;
    private String category;
    private String userId;

    public ProductListResponseDto(Product product) {
        this.productId = product.getId();
        this.name = product.getName();
        this.company = product.getCompany();
        this.category = product.getCategory();
        this.userId = product.getUser().getEmail();
    }
}
