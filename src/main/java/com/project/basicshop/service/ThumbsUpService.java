package com.project.basicshop.service;

import com.project.basicshop.domain.product.Product;
import com.project.basicshop.domain.product.ProductRepository;
import com.project.basicshop.domain.product.ThumbsUp;
import com.project.basicshop.domain.product.ThumbsUpRepository;
import com.project.basicshop.domain.user.User;
import com.project.basicshop.domain.user.UserRepository;
import com.project.basicshop.web.dto.ThumbsUpReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ThumbsUpService {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final ThumbsUpRepository thumbsUpRepository;

    public String thumbsUp(ThumbsUpReqDto thumbsUpReqDto) {
        Product product = productRepository.findById(thumbsUpReqDto.getProductId()).orElseThrow(() -> new IllegalArgumentException("해당 상품이 존재하지 않습니다."));
        User user = userRepository.findByEmail(thumbsUpReqDto.getUserEmail()).orElseThrow(() -> new IllegalArgumentException("해당 유저가 존재하지 않습니다."));

        ThumbsUp thumbsUp = ThumbsUp.builder()
                .product(product)
                .user(user)
                .build();

        thumbsUpRepository.save(thumbsUp);

        return "success";
    }

    public String deleteThumbsUp(Long thumbsUpId) {
        thumbsUpRepository.deleteById(thumbsUpId);

        return "success";
    }
}
