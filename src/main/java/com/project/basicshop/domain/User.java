package com.project.basicshop.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Entity
public class User {

    @Id @GeneratedValue
    private Long id;

    private String email;

    private String username;

    private String password;

}
