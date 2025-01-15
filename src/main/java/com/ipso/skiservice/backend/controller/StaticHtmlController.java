package com.ipso.skiservice.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StaticHtmlController {

    @GetMapping("/req/login")
    public String login() {
        return "login";
    }

    @GetMapping("/req/signup")
    public String signup() {
        return "signup";
    }

    @GetMapping("/index")
    public String home() {
        return "index";
    }

    @GetMapping("/kontaktseite")
    public String Kontaktseite() {
        return "Kontaktseite";
    }

    @GetMapping("/ueberuns")
    public String ueberuns() {
        return "ueberuns";
    }

    @GetMapping("/dienstleistungen")
    public String dienstleistungen() {
        return "dienstleistungen";
    }
}