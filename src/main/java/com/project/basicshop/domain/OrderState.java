package com.project.basicshop.domain;

import javax.persistence.Embeddable;

@Embeddable
public enum OrderState {

    PAYMENT_WAITING, PREPARING, SHIPPED, DELIVERY_COMPLETED;
}
