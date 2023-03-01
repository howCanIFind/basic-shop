package com.project.basicshop.web.dto;

import lombok.Getter;

@Getter
public class ReviewReqDto {

    private Long productId;

    private String userEmail;

    private String content;

    private Long reating;
}
