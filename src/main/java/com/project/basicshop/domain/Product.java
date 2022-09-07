package com.project.basicshop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {

    @Id @GeneratedValue
    @Column
    private Long id;

    private String productName;

    private String category;

    private String conpanyName;

}
