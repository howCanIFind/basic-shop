package com.project.basicshop.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Order {

    @Id @GeneratedValue
    @Column
    private Long id;

    @Embedded
    private OrderState state;

    @Embedded
    private ShippingInfo shippingInfo;

}
