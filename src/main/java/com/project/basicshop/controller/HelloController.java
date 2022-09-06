package com.project.basicshop.controller;

import com.project.basicshop.ExampleDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HelloController {

    @GetMapping("/")
    public String hello() {
        return "hello";
    }

    @PostMapping("/api/example")
    public String example() {
        return "success";
    }
}
