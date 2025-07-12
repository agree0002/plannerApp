package com.igrus.demo.demo;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(HttpSession session) {
        // 세션에서 사용자 정보 확인
        if (session.getAttribute("user_index") == null) {
            return "redirect:/login"; // 로그인되지 않은 경우 로그인 페이지로 리다이렉트
        }

        return "home"; // 로그인된 사용자만 home.html 반환
    }
}