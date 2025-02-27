package com.rollerspeed.v1.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index"; // Sin la extensión .html, Thymeleaf la busca automáticamente en templates
    }
}
