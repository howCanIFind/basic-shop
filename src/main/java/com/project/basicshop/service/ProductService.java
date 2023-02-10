package com.project.basicshop.service;

import com.project.basicshop.domain.product.Product;
import com.project.basicshop.domain.user.User;
import com.project.basicshop.domain.user.UserRepository;
import com.project.basicshop.web.dto.ProductResponseDto;
import com.project.basicshop.web.dto.ProductSaveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final UserRepository userRepository;

    @Transactional
    public ProductResponseDto saveProduct(ProductSaveDto productSaveDto) {
        User user = userRepository.findByEmail(productSaveDto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 존재하지 않습니다. email=" + productSaveDto.getUserId()));
        Product product = productSaveDto.toEntity(user);

        return ProductResponseDto.builder()
                .name(product.getName())
                .company(product.getCompany())
                .category(product.getCategory())
                .userId(product.getUser().getEmail())
                .build();
    }

    // read

    //update

    // delete
}
