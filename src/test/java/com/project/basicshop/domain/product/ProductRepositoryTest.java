package com.project.basicshop.domain.product;

import com.project.basicshop.domain.user.Role;
import com.project.basicshop.domain.user.User;
import com.project.basicshop.domain.user.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    UserRepository userRepository;

    @AfterEach
    public void cleanup() {
        productRepository.deleteAll();
    }

    @Test
    public void 게시글저장() {
        // given
        User user = User.builder()
                .email("이메일")
                .name("유저 이름")
                .picture("사진")
                .role(Role.USER)
                .build();
        User savedUser = userRepository.save(user);
        Product product = Product.builder()
                .name("상품 이름")
                .company("회사 이름")
                .category("카테고리")
                .price(10000L)
                .user(savedUser)
                .build();

        // when
        Product savedProduct = productRepository.save(product);

        // then
        Product findProduct = productRepository.findById(savedProduct.getId()).get();
        assertThat(findProduct.getName()).isEqualTo(savedProduct.getName());
        assertThat(findProduct.getCompany()).isEqualTo(savedProduct.getCompany());
        assertThat(findProduct.getCategory()).isEqualTo(savedProduct.getCategory());
        assertThat(findProduct.getPrice()).isEqualTo(savedProduct.getPrice());
    }

    @Test
    public void 게시글_전체_조회() {
        // given
        User user = User.builder()
                .email("이메일")
                .name("유저 이름")
                .picture("사진")
                .role(Role.USER)
                .build();
        User savedUser = userRepository.save(user);
        Product product1 = Product.builder()
                .name("상품 이름1")
                .company("회사 이름1")
                .category("카테고리1")
                .price(10000L)
                .user(savedUser)
                .build();
        Product product2 = Product.builder()
                .name("상품 이름2")
                .company("회사 이름2")
                .category("카테고리2")
                .price(10000L)
                .user(savedUser)
                .build();
        productRepository.save(product1);
        productRepository.save(product2);


        // when
        List<Product> result = productRepository.findAll();

        //then
        assertThat(result.size()).isEqualTo(2);
//        assertThat(result).contains(savedProduct1, savedProduct2);
    }
}