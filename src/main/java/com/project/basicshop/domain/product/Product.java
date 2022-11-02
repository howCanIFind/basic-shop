package com.project.basicshop.domain.product;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter
public abstract class Product {

    @Id @GeneratedValue
    @Column
    private Long id;

    private String productName;

    private String companyName;

}
