package com.project.basicshop.domain.product;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("I")
public class ITDevice extends Product{

    private String warrantyDate;

    protected ITDevice() {
    }

    public ITDevice(String productName, String companyName, Integer price, Integer deliveryFee , String warrantyDate) {
        productName = productName;
        companyName = companyName;
        price = price;
        deliveryFee = deliveryFee;
        this.warrantyDate = warrantyDate;
    }
}
