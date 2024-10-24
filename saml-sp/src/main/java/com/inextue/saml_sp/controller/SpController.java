package com.inextue.saml_sp.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SpController {

    @GetMapping("/login")
    public String login() {
        return "login"; // Return login view
    }

    @GetMapping("/home")
    public String home() {
        return "home"; // Return home view after successful login
    }
}
