package com.project.basicshop.domain.product;

import com.project.basicshop.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String company;

    private String category;

    private Long price;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Builder
    public Product(String name, String company, String category, Long price, User user) {
        this.name = name;
        this.company = company;
        this.category = category;
        this.price = price;
        this.user = user;
    }

    public void update(String name, String company,String category, Long price) {
        this.name = name;
        this.company = company;
        this.category = category;
        this.price = price;
    }
}