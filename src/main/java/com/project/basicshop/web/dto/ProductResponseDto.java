package com.project.basicshop.web.dto;

import lombok.Builder;

public class ProductResponseDto {
    private String name;
    private String company;
    private String category;
    private String userId;

    @Builder
    public ProductResponseDto(String name, String company, String category, String userId) {
        this.name = name;
        this.company = company;
        this.category = category;
        this.userId = userId;
    }
}
