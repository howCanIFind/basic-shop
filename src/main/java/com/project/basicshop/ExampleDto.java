package com.project.basicshop;

import lombok.Getter;

public class ExampleDto {
    private String name;
    private String age;

    public ExampleDto(String name, String age) {
        this.name = name;
        this.age = age;
    }
}
