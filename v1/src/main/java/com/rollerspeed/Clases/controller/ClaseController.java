package com.rollerspeed.Clases.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.rollerspeed.Clases.model.Clase;

import java.util.Arrays;
import java.util.List;

@Controller
public class ClaseController {

    @GetMapping("/clases")
    public String mostrarClases(Model model) {
        // Crear una lista de clases
        List<Clase> clases = Arrays.asList(
            new Clase("Yoga", "Lunes y Miércoles 10:00 AM", "Principiante"),
            new Clase("Pilates", "Martes y Jueves 4:00 PM", "Intermedio"),
            new Clase("Spinning", "Viernes 6:00 PM", "Avanzado")
        );

        // Agregar la lista al modelo
        model.addAttribute("clases", clases);

        // Retornar la vista (nombre del archivo HTML sin extensión)
        return "clases";
    }
}