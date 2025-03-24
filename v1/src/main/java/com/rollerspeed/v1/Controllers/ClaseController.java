package com.rollerspeed.v1.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rollerspeed.v1.Service.ClaseServicio;
import com.rollerspeed.v1.Model.Clase;

@Controller
@RequestMapping("/clases")
public class ClaseController {

    @Autowired
    ClaseServicio claseServicio;

    @GetMapping("/horario")
    public String listaClases(Model modelo) {
        modelo.addAttribute("clases",claseServicio.listarTodasLasClases());
        return "Horarios/horario1";
    }

    @GetMapping("/registro")
    public String formularioRegistro(Model modelo) {
        modelo.addAttribute("clase", new Clase());
        return "registro_clases";
    }
    @PostMapping("/registro")
    public String registrarClase(@ModelAttribute Clase clase){
        claseServicio.registrarClase(clase);
        return "redirect:/clases/registro";
    }

    
}
