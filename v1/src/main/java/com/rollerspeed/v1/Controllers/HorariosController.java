package com.rollerspeed.v1.Controllers;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rollerspeed.v1.Repository.HorariosEstudiantesRepositorio;

@Controller
@RequestMapping("/horarios")
public class HorariosController {

    private final HorariosEstudiantesRepositorio HorariosEstudiantes;

    private final JdbcTemplate jdbcTemplate;

    public HorariosController(HorariosEstudiantesRepositorio HorariosEstudiantes,JdbcTemplate jdbcTemplate) {
        this.HorariosEstudiantes = HorariosEstudiantes;
        this.jdbcTemplate = jdbcTemplate;
    }

    
    @PostMapping("/estudiantes")
    public String crearHorariosEstudiantes(Model modelo) {
        HorariosEstudiantes.crearHorariosEstudiantes();
        return "Horarios/horariosestudiantes";
    }

    @GetMapping("/estudiantes")
    public String HorariosEstudiantes(Model modelo) {
        return obtenerYEnviarHorarios(modelo);
    }

    private String obtenerYEnviarHorarios(Model modelo){
        List<Map<String, Object>> resultados = jdbcTemplate.queryForList("SELECT * FROM horarios_estudiantes");
        modelo.addAttribute("resultados", resultados);
        return "Horarios/horariosestudiantes";
    }
}
