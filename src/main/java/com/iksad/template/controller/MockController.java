package com.iksad.template.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MockController {
    @GetMapping("/api/v1/login")
    public String getForTest() {
        System.out.println("test");
        return "성공적인 호출";
    }
}
