package com.project.basicshop.domain;

import lombok.Getter;

@Getter
public class OrderLine {

    private Product product;
    private Money price;
    private int qauntity;
    private Money amounts;
}
