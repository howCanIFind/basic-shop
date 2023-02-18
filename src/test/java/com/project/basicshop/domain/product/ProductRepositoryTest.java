package com.project.basicshop.domain.product;

import com.project.basicshop.domain.user.Role;
import com.project.basicshop.domain.user.User;
import com.project.basicshop.domain.user.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
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
    public void 게시글저장_test() {
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
        assertEquals(findProduct.getName(), savedProduct.getName());
        assertEquals(findProduct.getCompany(), savedProduct.getCompany());
        assertEquals(findProduct.getCategory(), savedProduct.getCategory());
        assertEquals(findProduct.getPrice(), savedProduct.getPrice());
    }

    @Test
    public void 게시글_전체_조회_test() {
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
        assertEquals(result.size(), 2);
//        assertThat(result).contains(savedProduct1, savedProduct2);
    }

    @Test
    public void 책삭제_test() {
        // given
        String name = "상품 이름";
        String company = "회사 이름";
        String category = "카테고리";
        Long price = 10000L;
        Product product = Product.builder()
                .name(name)
                .company(company)
                .category(category)
                .price(price)
                .build();
        Product savedProduct = productRepository.save(product);
        Long id = savedProduct.getId();
        System.out.println(id);

        // when
        productRepository.deleteById(id);

        // then
        assertFalse(productRepository.findById(id).isPresent());

    }
}