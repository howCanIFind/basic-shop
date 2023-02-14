package com.project.basicshop.web.dto;

import com.project.basicshop.domain.product.Product;
import com.project.basicshop.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductSaveDto {

    private String userId;
    private String name;
    private String company;
    private String category;
    private Long price;

    public ProductSaveDto(String userId, String name, String company, String category, Long price) {
        this.userId = userId;
        this.name = name;
        this.company = company;
        this.category = category;
        this.price = price;
    }

    public Product toEntity(User user) {
        return Product.builder()
                .name(name)
                .company(company)
                .category(category)
                .price(price)
                .user(user)
                .build();
    }
}
