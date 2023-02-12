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

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Builder
    public Product(String name, String company, String category, User user) {
        this.name = name;
        this.company = company;
        this.category = category;
        this.user = user;
    }

    public void update(String name, String company,String category) {
        this.name = name;
        this.company = company;
        this.category = category;
    }
}

//product 도메인 정하기
//
//crud 완성하기
//
//
//login 만들기