package com.ipso.skiservice.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StaticHtmlController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @GetMapping("/index")
    public String home() {
        return "index";
    }

    @GetMapping("/req/login")
    public String index() {
        return "index";
    }

    @GetMapping("/swagger")
    public String swagger() {
        return "/swagger-ui.html";
    }
}