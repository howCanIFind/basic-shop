package com.project.basicshop.domain.product;

import javax.persistence.*;

@Entity
public class Review {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long rating;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;
}
