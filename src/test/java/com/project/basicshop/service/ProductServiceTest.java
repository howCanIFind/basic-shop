package com.project.basicshop.service;

import com.project.basicshop.domain.product.Product;
import com.project.basicshop.domain.product.ProductRepository;
import com.project.basicshop.domain.user.Role;
import com.project.basicshop.domain.user.User;
import com.project.basicshop.domain.user.UserRepository;
import com.project.basicshop.web.dto.ProductResponseDto;
import com.project.basicshop.web.dto.ProductSaveDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ActiveProfiles("dev")
@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private UserRepository userRepository;

    @Test
    public void 상품등록하기_test() {
        // given
        ProductSaveDto productSaveDto = new ProductSaveDto("이메일", "상품 이름", "회사 이름", "카테고리", 10000L);

        // stub
        User user = User.builder()
                .name("유저 이름")
                .email("이메일")
                .role(Role.USER)
                .picture("사진")
                .build();
        when(userRepository.findByEmail(any())).thenReturn(Optional.of(user));

        // when
        ProductResponseDto productResponseDto = productService.saveProduct(productSaveDto);

        // then
        assertThat(productResponseDto.getUserId()).isEqualTo(productSaveDto.getUserId());
        assertThat(productResponseDto.getName()).isEqualTo(productSaveDto.getName());
        assertThat(productResponseDto.getCompany()).isEqualTo(productSaveDto.getCompany());
        assertThat(productResponseDto.getCategory()).isEqualTo(productSaveDto.getCategory());
        assertThat(productResponseDto.getPrice()).isEqualTo(productSaveDto.getPrice());
    }

    @Test
    public void 상품한건보기_test() {
        // given
        Long id = 1L;

        // stub
        User user = User.builder()
                .name("유저 이름")
                .email("이메일")
                .role(Role.USER)
                .picture("사진")
                .build();
        Product product = Product.builder()
                .name("상품 이름")
                .company("회사 이름")
                .category("카테고리")
                .price(10000L)
                .user(user)
                .build();
        when(productRepository.findById(id)).thenReturn(Optional.ofNullable(product));

        // when
        ProductResponseDto productResponseDto = productService.findProduct(id);

        // then
        assertThat(productResponseDto.getUserId()).isEqualTo(product.getUser().getEmail());
        assertThat(productResponseDto.getName()).isEqualTo(product.getName());
        assertThat(productResponseDto.getCompany()).isEqualTo(product.getCompany());
        assertThat(productResponseDto.getCategory()).isEqualTo(product.getCategory());
        assertThat(productResponseDto.getPrice()).isEqualTo(product.getPrice());
    }

}