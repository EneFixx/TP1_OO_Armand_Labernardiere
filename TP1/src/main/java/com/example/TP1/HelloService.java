package com.example.TP1;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloService {

    @GetMapping("/")
    public String hello() {
        return "hello";
    }
}