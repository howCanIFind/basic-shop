package com.project.basicshop.domain.product;

import com.project.basicshop.domain.user.User;

import javax.persistence.*;

@Entity
public class ThumbsUp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    User user;

    @OneToOne(fetch = FetchType.LAZY)
    Product product;
}
