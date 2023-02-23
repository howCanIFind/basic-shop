package com.project.basicshop.web.dto;

import com.project.basicshop.domain.product.Product;
import lombok.Getter;

@Getter
public class ProductListResponseDto {
    private Long productId;
    private String name;
    private String company;
    private String category;
    private Long price;
    private String userId;

    public ProductListResponseDto(Product product) {
        this.productId = product.getId();
        this.name = product.getName();
        this.company = product.getCompany();
        this.category = product.getCategory();
        this.price = product.getPrice();
        this.userId = product.getUser().getEmail();
    }
}
