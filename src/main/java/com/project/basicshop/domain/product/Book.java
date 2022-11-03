package com.project.basicshop.domain.product;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("B")
public class Book extends Product{

    private String author;

    private LocalDateTime yearOfIssue;

    private Integer page;

    private String publisher;

    protected Book() {

    }

    public Book(String productName, String companyName, Integer price, Integer deliveryFee , String author, LocalDateTime yearOfIssue, Integer page, String publisher) {
        productName = productName;
        companyName = companyName;
        price = price;
        deliveryFee = deliveryFee;
        this.author = author;
        this.yearOfIssue = yearOfIssue;
        this.page = page;
        this.publisher = publisher;
    }
}
