package com.rollerspeed.v1.Controllers;

import com.rollerspeed.v1.Model.Profesor;
import com.rollerspeed.v1.Service.ClaseService;
import com.rollerspeed.v1.Service.ProfesorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/profesores")
public class ProfesorController {

    private final ProfesorService profesorService;
    @Autowired
    ClaseService claseServicio;

    public ProfesorController(ProfesorService profesorService) {
        this.profesorService = profesorService;
    }

    @GetMapping
    public String listarProfesores(Model model) {
        model.addAttribute("profesores", profesorService.listarProfesores());
        return "listar_profesores";
    }

    @GetMapping("/registro")
    public String formularioRegistro(Model model) {
        model.addAttribute("profesor", new Profesor());
        model.addAttribute("clases",claseServicio.listarTodasLasClases());
        return "registro_profesor";

    }

    @PostMapping("/registro")
    public String registrarProfesor(@ModelAttribute Profesor profesor) {
        profesorService.registrarProfesor(profesor);
        return "redirect:/profesores/registro";
    }
}