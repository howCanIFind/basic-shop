package com.project.basicshop.domain.product;

import com.project.basicshop.domain.user.User;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class ThumbsUp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    User user;

    @OneToOne(fetch = FetchType.LAZY)
    Product product;

    @Builder
    public ThumbsUp(User user, Product product) {
        this.user = user;
        this.product = product;
    }
}
