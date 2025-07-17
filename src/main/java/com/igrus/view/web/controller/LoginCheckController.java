package com.igrus.view.web.controller;

import com.igrus.view.domain.user.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginCheckController {

    @Autowired
    private UserService userService;

    @PostMapping("/login-check")
    public String login(@RequestParam String email, @RequestParam String password, Model model, HttpSession session) {
        try{
            if (userService.authenticateUser(email, password)) {
                int userId = userService.getUserId(email);
                session.setAttribute("user_index", userId);
                return "redirect:/home";
            } else {
                model.addAttribute("errorMessage", "이메일이나 비밀번호가 다릅니다.");
                return "login";
            }

        }
        catch(Exception e){
            model.addAttribute("errorMessage", "이메일이 존재하지 않습니다.");
            return "login";
        }
    }

}
