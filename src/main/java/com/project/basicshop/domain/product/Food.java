package com.project.basicshop.domain.product;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("F")
public class Food extends Product{

    private String areaOfProduction;

    protected Food() {
    }

    public Food(String productName, String companyName, Integer price, Integer deliveryFee , String areaOfProduction) {
        productName = productName;
        companyName = companyName;
        price = price;
        deliveryFee = deliveryFee;
        this.areaOfProduction = areaOfProduction;
    }
}
