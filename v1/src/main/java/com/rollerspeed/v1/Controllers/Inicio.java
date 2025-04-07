 package com.rollerspeed.v1.Controllers;

 import org.springframework.stereotype.Controller;
 import org.springframework.web.bind.annotation.GetMapping;


 @Controller
 public class Inicio {
    
     @GetMapping("/inicio")
     public String inicio() {
         return "inicio";
     }
 }
