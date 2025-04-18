package com.rollerspeed.v1.Controllers;

import com.rollerspeed.v1.DTO.EstudianteDTO;
import com.rollerspeed.v1.Model.Estudiante;
import com.rollerspeed.v1.Model.UserEntity;
import com.rollerspeed.v1.Service.ClaseServicio;
import com.rollerspeed.v1.Service.EstudianteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;


import org.springframework.validation.BindingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;


@Tag(name = "Estudiantes", description = "Operaciones con estudiantes")
@Controller
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    EstudianteService estudianteService;
    @Autowired
    ClaseServicio claseServicio;


    @GetMapping
    @Operation(
            summary = "Crear lista de estudiantes",
            description = "Devuelve la lista de todos los estudiantes en la base hasta ahora",
            responses = {
                    @ApiResponse( responseCode = "200", description = "Se ha obtenido la lista de estudiantes",
                            content = @Content(schema = @Schema(implementation = EstudianteDTO.class))),
                    @ApiResponse(responseCode = "500", description = "Error obteniendo la lista de estudiantes")
            }
    )
    public String listarEstudiantes(Model model) {
        model.addAttribute("estudiantes", estudianteService.listarEstudiantes());
        return "Estudiantes/listar_estudiantes";
    }

    @GetMapping("/registro")
    @Operation(
            summary = "Envio del modelo estudiante y lista de clases",
            description = "Se crea un nuevo modelo de estudiante y se envia las lista de clases " +
                    "disponibles para inscripción, de tal manera que el nuevo estudiante queda registrado" +
                    "de una vez en al menos una clase"
    )
    public String formularioRegistro(Model model) {
        model.addAttribute("estudianteDTO", new EstudianteDTO());
        model.addAttribute("clases",claseServicio.listarTodasLasClases());
        return "Estudiantes/registro_estudiante";

    }

    @PostMapping("/registro")
    @Operation(
            summary = "Registrar Estudiante",
            description = "Recibe un nuevo estudiante y lo añade a la base de datos"
    )
    public String registrarEstudiante(
            @Parameter(description = "Datos del estudiante a registrar.", required = true, content = @Content(schema = @Schema(implementation = EstudianteDTO.class)))
            @Valid @ModelAttribute EstudianteDTO estudianteDTO,
            BindingResult result,
            Model model) {

        if(result.hasErrors()){
            model.addAttribute("clases",claseServicio.listarTodasLasClases());
            return "Estudiantes/registro_estudiante";
        }
        estudianteService.registrarEstudiante(estudianteDTO);
        return "redirect:/estudiantes/registro";
    }

    @GetMapping("/editar/{id}")
    @Operation(
        summary = "Editar datos estudiante",
        description = "Busca los datos de un estudiante por Id y lo envia para su edicion"
    )
    public String editarEstudiante(@PathVariable Long id, Model model) {
        model.addAttribute("estudiante", estudianteService.ObtenerId(id));
        model.addAttribute("clases",claseServicio.listarTodasLasClases());
        return "Estudiantes/editar_estudiantes";
    }

    @PostMapping("/{id}")
    @Operation(
        summary = "Actualizar estudiante",
        description = "Recibe los nuevos datos de un estudiante y los actualiza"
    )
    public String actualizarEstudiante(@PathVariable Long id, @ModelAttribute("estudiante") Estudiante datosNuevos){
        Estudiante datosAntiguos = estudianteService.ObtenerId(id);
        estudianteService.ActualizarEstudiante(datosAntiguos, datosNuevos);
        return "redirect:/estudiantes";
    }

    @GetMapping("/eliminar/{id}")
    @Operation(
        summary = "Eliminar estudiante",
        description = "Selecciona un estudiante por Id y lo borra de la base de datos"
    )
    public String eliminarEstudiante(@PathVariable Long id){
        estudianteService.EliminarEstudiante(id);
        return "redirect:/estudiantes";
    }
    
}