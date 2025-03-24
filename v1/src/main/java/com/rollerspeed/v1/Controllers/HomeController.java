package com.rollerspeed.v1.Controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;





@Controller
public class HomeController {


    @GetMapping("/")
    public String home() {
        return "index"; // Sin la extensión .html, Thymeleaf la busca automáticamente en templates
    }

    @GetMapping("Nosotros/vision")
    public String vision() {
        return "Nosotros/vision";
    }
    @GetMapping("Nosotros/mision")
    public String mision() {
        return "Nosotros/mision";
    }
    @GetMapping("Nosotros/servicios")
    public String servicios() {
        return "Nosotros/servicios";
    }
    @GetMapping("Nosotros/valores")
    public String valores() {
        return "Nosotros/valores";
    }

    @GetMapping("Nosotros/eventos")
    public String eventos() {
        return "Nosotros/eventos";
    }

}
