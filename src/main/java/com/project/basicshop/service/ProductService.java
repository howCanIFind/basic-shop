package com.project.basicshop.service;

import com.project.basicshop.domain.product.Product;
import com.project.basicshop.domain.product.ProductRepository;
import com.project.basicshop.domain.user.User;
import com.project.basicshop.domain.user.UserRepository;
import com.project.basicshop.web.dto.ProductListResponseDto;
import com.project.basicshop.web.dto.ProductResponseDto;
import com.project.basicshop.web.dto.ProductSaveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;

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
    @Transactional(readOnly = true)
    public List<ProductListResponseDto> findAllDesc() {
        return productRepository.findAllDesc().stream()
                .map(ProductListResponseDto::new)
                .collect(Collectors.toList());
    }

    //update


    // delete
}
