package com.project.basicshop.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Member {

    @Id @GeneratedValue
    @Column
    private Long id;

    private String name;

    private int age;

    private String gender;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<ProductMember> productMembers = new ArrayList<>();

}
