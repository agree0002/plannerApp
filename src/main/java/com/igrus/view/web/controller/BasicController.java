package com.igrus.view.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BasicController {
    @GetMapping("/")
    String index() {
        return "index.html";
    }
}
