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
import com.rollerspeed.v1.Repository.HorariosProfesoresRepositorio;

@Controller
@RequestMapping("/horarios")
public class HorariosController {

    private final HorariosEstudiantesRepositorio HorariosEstudiantes;

    private final HorariosProfesoresRepositorio HorariosProfesores;

    private final JdbcTemplate jdbcTemplate;

    private boolean vistaEstudianteCreada = false;
    private boolean vistaProfesorCreada = false;

    public HorariosController(HorariosEstudiantesRepositorio HorariosEstudiantes,JdbcTemplate jdbcTemplate, HorariosProfesoresRepositorio HorariosProfesores) {
        this.HorariosEstudiantes = HorariosEstudiantes;
        this.jdbcTemplate = jdbcTemplate;
        this.HorariosProfesores = HorariosProfesores;
    }

    
    @PostMapping("/estudiantes")
    public String crearHorariosEstudiantes(Model modelo) {
        return obtenerYEnviarHorarios(modelo, "horarios_estudiantes","Horarios/horariosestudiantes");
    }

    @GetMapping("/estudiantes")
    public String HorariosEstudiantes(Model modelo) {
        return obtenerYEnviarHorarios(modelo, "horarios_estudiantes","Horarios/horariosestudiantes");
    }

    private String obtenerYEnviarHorarios(Model modelo, String Vista, String Ruta){
        try{
            if(!vistaEstudianteCreada){
                if(!vistaExiste(Vista)){
                    HorariosEstudiantes.crearHorariosEstudiantes();
                }
                vistaProfesorCreada = true;
            }
            List<Map<String, Object>> resultados = jdbcTemplate.queryForList("SELECT * FROM horarios_estudiantes");
            modelo.addAttribute("resultados", resultados);
            return Ruta;
        }catch( Exception e){
            modelo.addAttribute("Error", "No funciona: "+e.getMessage());
            return "error";
        }
        
    }

    private boolean vistaExiste(String Vista){
        try{
            jdbcTemplate.queryForObject("Select 1 from "+Vista+" limit 1", Integer.class);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
      
    @PostMapping("/profesores")
    public String crearHorariosProfesores(Model modelo) {
        return obtenerYEnviarHorariosProfesores(modelo, "horarios_estudiantes","Horarios/horariosprofesores");
    }

    @GetMapping("/profesores")
    public String HorariosProfesores(Model modelo) {
        return obtenerYEnviarHorariosProfesores(modelo, "horarios_estudiantes","Horarios/horariosprofesores");
    }

    private String obtenerYEnviarHorariosProfesores(Model modelo, String Vista, String Ruta){
        try{
            if(!vistaProfesorCreada){
                if(!vistaExiste(Vista)){
                    HorariosProfesores.crearHorariosProfesores();
                }
                vistaProfesorCreada = true;
            }
            List<Map<String, Object>> resultados = jdbcTemplate.queryForList("SELECT * FROM horarios_profesores");
            modelo.addAttribute("resultados", resultados);
            return Ruta;
        }catch( Exception e){
            modelo.addAttribute("Error", "No funciona: "+e.getMessage());
            return "error";
        }
        
    }
    

}
