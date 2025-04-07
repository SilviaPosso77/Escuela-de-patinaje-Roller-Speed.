 package com.rollerspeed.v1.Controllers;
 import io.swagger.v3.oas.annotations.Operation;
 import io.swagger.v3.oas.annotations.tags.Tag;
 import org.springframework.stereotype.Controller;
 import org.springframework.web.bind.annotation.GetMapping;




 @Tag(name="Home", description = "Dirección a paginas principales")
 @Controller
 public class HomeController {

     @Operation(
         summary= "Ingreso a paginas sobre nosotros",
         description = "Devuelve la conexion con las paginas de Nosotros, que suelen estar estaticas y " +
                 "solo contienen información sobre nuestra escuela"
     )

     @GetMapping("/")
     public String home() {
         return "inicio"; // Sin la extensión .html, Thymeleaf la busca automáticamente en templates
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

