package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")    // 로컬호스트 8080으로 들어오면 이게 딱 호출됨
    public String home() {
        return "home";  // home.html 호출
    }
}
