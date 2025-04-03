package com.rollerspeed.v1.Controllers;

import java.util.List;
import java.util.Map;

import com.rollerspeed.v1.DTO.HorarioEstudiantesDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rollerspeed.v1.Repository.HorariosEstudiantesRepositorio;
import com.rollerspeed.v1.Repository.HorariosProfesoresRepositorio;

@Tag(name="Horarios", description = "Operaciones para visualizar los horarios")
@Controller
@RequestMapping("/horarios")
public class HorariosController {

    @Autowired
    HorariosEstudiantesRepositorio HorariosEstudiantes;
    @Autowired
    HorariosProfesoresRepositorio HorariosProfesores;
    @Autowired
    JdbcTemplate jdbcTemplate;

    private boolean vistaEstudianteCreada = false;
    private boolean vistaProfesorCreada = false;



    @PostMapping("/estudiantes")
    @Operation(
            summary = "Creacion de vista horario estudiantes",
            description = "Creación de vista sql para la visualización de los horarios de los estudiantes",
            responses = {
                    @ApiResponse( responseCode = "200", description = "Se ha creado vista de horarios estudiantes",
                    content = @Content(schema = @Schema(implementation = HorarioEstudiantesDTO.class))),
                    @ApiResponse(responseCode = "500", description = "Error creando y obteniendo la lista")
            }
    )
    public String crearHorariosEstudiantes(Model modelo) {
        return obtenerYEnviarHorarios(modelo, "horarios_estudiantes","Horarios/horariosestudiantes");
    }

    @GetMapping("/estudiantes")
    @Operation(summary = "Envio de la vista sql de estudiantes", description = "Se envia la vista sql para su visualizacion")
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
      
    @PostMapping("/profesores")
    @Operation(
            summary = "Creacion de vista horario profesores",
            description = "Creación de vista sql para la visualización de los horarios de los profesores")
    public String crearHorariosProfesores(
            Model modelo) {
        return obtenerYEnviarHorariosProfesores(modelo, "horarios_estudiantes","Horarios/horariosprofesores");
    }

    @GetMapping("/profesores")
    @Operation(summary = "Envio de la vista sql de profesores", description = "Se envia la vista sql para su visualizacion")
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

    private boolean vistaExiste(String Vista){
        try{
            jdbcTemplate.queryForObject("Select 1 from "+Vista+" limit 1", Integer.class);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    

}
