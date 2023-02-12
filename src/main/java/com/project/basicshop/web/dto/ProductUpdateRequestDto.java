package com.project.basicshop.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductUpdateRequestDto {
    private String name;
    private String company;
    private String category;

    @Builder
    public ProductUpdateRequestDto(String name, String company, String category) {
        this.name = name;
        this.company = company;
        this.category = category;
    }
}
