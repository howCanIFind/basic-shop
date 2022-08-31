package com.project.basicshop.domain;

import lombok.Getter;

import javax.persistence.*;

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

    

}
