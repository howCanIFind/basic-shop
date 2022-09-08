package com.project.basicshop.domain;

import javax.persistence.*;

@Entity
public class ProductMember {

    @Id @GeneratedValue
    @Column
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

}
