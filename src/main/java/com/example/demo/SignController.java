package com.example.demo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor //이 어노테이션 써야 DB 불러올 수 있음
public class SignController {

    private final UserRepository userRepository;

    @GetMapping("/signup")
    String signup() {
        return "signup.html";
    }

    @PostMapping("/addUserStatus")
    String addUserStatus(@RequestParam(name = "username")
                         String username, @RequestParam(name = "email")
                         String email, @RequestParam(name = "password") String password,
                         @RequestParam(name ="confirmPassword") String confirmPassword, Model model) {
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);

        if (!confirmPassword.equals(password)) {
            model.addAttribute("errorMessage", "비밀번호가 일치하지 않습니다.");
            return "signup.html";
        }
        else {
            userRepository.save(user);
            return "index.html";

        }

    }
}
