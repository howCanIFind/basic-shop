package com.project.basicshop.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Address {

    private String shippingAddress1;

    private String shippingAddress2;

    private String shippingZipcode;
}
