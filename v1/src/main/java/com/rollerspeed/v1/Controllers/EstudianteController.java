package com.rollerspeed.v1.Controllers;

import com.rollerspeed.v1.Model.Estudiante;
import com.rollerspeed.v1.Service.ClaseServicio;
import com.rollerspeed.v1.Service.EstudianteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteController {

    private final EstudianteService estudianteService;
    @Autowired
    ClaseServicio claseServicio;

    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @GetMapping
    public String listarEstudiantes(Model model) {
        model.addAttribute("estudiantes", estudianteService.listarEstudiantes());
        return "listar_estudiantes";
    }

    @GetMapping("/registro")
    public String formularioRegistro(Model model) {
        model.addAttribute("estudiante", new Estudiante());
        model.addAttribute("clases",claseServicio.listarTodasLasClases());
        return "registro_estudiante";

    }

    @PostMapping("/registro")
    public String registrarEstudiante(@ModelAttribute Estudiante estudiante) {
        estudianteService.registrarEstudiante(estudiante);
        return "redirect:/estudiantes/registro";
    }
}