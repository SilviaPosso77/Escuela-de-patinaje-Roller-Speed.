package com.rollerspeed.v1.Controllers;

import com.rollerspeed.v1.Service.HorarioEstudianteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.rollerspeed.v1.Service.HorarioProfesorServicio;
import com.rollerspeed.v1.Repository.EstudianteRepository;
import com.rollerspeed.v1.Repository.HorariosEstudiantesRepositorio;
import com.rollerspeed.v1.Service.ClaseServicio;
import java.util.List;
import java.util.Map;



@Controller
public class HomeController {

    @Autowired
    ClaseServicio claseServicio;

    @Autowired
    HorarioProfesorServicio HorarioProfesorServicio;

    @Autowired
    HorarioEstudianteServicio HorarioEstudianteServicio;

    @GetMapping("/")
    public String home() {
        return "index"; // Sin la extensión .html, Thymeleaf la busca automáticamente en templates
    }

    @GetMapping("Horarios/horario")
    public String listaClases(Model modelo) {
        modelo.addAttribute("clases",claseServicio.listarTodasLasClases());
        return "Horarios/horario";
    }

    @GetMapping("Horarios/horarioprofesores")
    public String HorarioProfesores(Model modelo) {
        modelo.addAttribute("HorarioProfesores",HorarioProfesorServicio.mostrarHorariosProfesores());
        return "Horarios/horarioprofesores";
    }

    @GetMapping("Horarios/horarioestudiantes")
    public String HorarioEstudiantes(Model modelo) {
        modelo.addAttribute("HorarioEstudiantes", HorarioEstudianteServicio.mostrarHorariosEstudiantes());
        return "Horarios/horarioestudiantes";
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
