package com.project.basicshop.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Member {

    @Id @GeneratedValue
    @Column
    private Long id;

    private String username;

    private String nickname;

    private String password;

    private String email;

}
