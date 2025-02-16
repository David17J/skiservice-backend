package com.ipso.skiservice.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StaticHtmlController {

    @GetMapping("/login")
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

    @GetMapping("/req/login")
    public String index() {
        return "index";
    }

    @GetMapping("/ueberuns")
    public String ueberuns() {
        return "ueberuns";
    }

    @GetMapping("/dienstleistungen")
    public String dienstleistungen() {
        return "dienstleistungen";
    }

    @GetMapping("/registrierung")
    public String registrierung() {
        return "registrierung";
    }

    @GetMapping("/impressum")
    public String impressum() {
        return "impressum";
    }

    @GetMapping("/agb")
    public String agb() {
        return "agb";
    }

    @GetMapping("/datenschutzerklärung")
    public String datenschutzerklärung() {
        return "datenschutzerklärung";
    }

    @GetMapping("/abgeschlossen")
    public String abgeschlossen() {
        return "abgeschlossen";
    }
}