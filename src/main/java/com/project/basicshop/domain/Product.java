package com.project.basicshop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {

    @Id @GeneratedValue
    @Column
    private Long id;

    private String productName;

    private String category;

    private String conpanyName;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<ProductMember> productMembers = new ArrayList<>();

}
