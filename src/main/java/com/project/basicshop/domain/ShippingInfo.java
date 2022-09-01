package com.project.basicshop.domain;

import lombok.Getter;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
@Getter
public class ShippingInfo {

    @Embedded
    private Receiver receiver;

    @Embedded
    private Address address;
}
