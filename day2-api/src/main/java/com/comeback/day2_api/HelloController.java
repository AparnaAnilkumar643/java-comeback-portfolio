package com.comeback.day2_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello(
            @RequestParam(value = "name", defaultValue = "Developer") String name) {

        return String.format(
                "Hello, %s! Welcome back to Spring Boot.",
                name);
    }

    @GetMapping("/add")
    public String addNumbers(
            @RequestParam int a,
            @RequestParam int b) {

        int sum = a + b;

        return String.format(
                "Result: %d + %d = %d",
                a, b, sum);
    }
}