package com.project.basicshop.domain.product;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("B")
public class Book extends Product{

    private String author;

    private LocalDateTime yearOfIssue;
}
