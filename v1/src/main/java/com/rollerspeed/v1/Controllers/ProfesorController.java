package com.rollerspeed.v1.Controllers;

import com.rollerspeed.v1.DTO.ProfesorDTO;
import com.rollerspeed.v1.Model.Profesor;
import com.rollerspeed.v1.Service.ClaseServicio;
import com.rollerspeed.v1.Service.ProfesorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Profesores", description = "Operaciones con profesores")
@Controller
@RequestMapping("/profesores")
public class ProfesorController {

    @Autowired
    ProfesorService profesorService;
    @Autowired
    ClaseServicio claseServicio;


    @GetMapping
    @Operation(
            summary = "Crear lista de profesores",
            description = "Devuelve la lista de todos los profesores en la base hasta ahora",
            responses = {
                    @ApiResponse( responseCode = "200", description = "Se ha obtenido la lista de profesores",
                            content = @Content(schema = @Schema(implementation = ProfesorDTO.class))),
                    @ApiResponse(responseCode = "500", description = "Error obteniendo la lista de profesores")
            }
    )
    public String listarProfesores(Model model) {
        model.addAttribute("profesores", profesorService.listarProfesores());
        return "listar_profesores";
    }

    @GetMapping("/registro")
    @Operation(
            summary = "Envio del modelo profesor y lista de clases",
            description = "Se crea un nuevo modelo de profesor y se envia las lista de clases " +
                    "disponibles para inscripción, de tal manera que el nuevo profesor queda registrado" +
                    "de una vez en al menos una clase"
    )
    public String formularioRegistro(Model model) {
        model.addAttribute("profesor", new Profesor());
        model.addAttribute("clases",claseServicio.listarTodasLasClases());
        return "registro_profesor";

    }

    @PostMapping("/registro")
    @Operation(
            summary = "Registrar Profesor",
            description = "Recibe un nuevo profesor y lo añade a la base de datos"
    )
    public String registrarProfesor(
            @Parameter(description = "Datos del profesor a registrar.", required = true, content = @Content(schema = @Schema(implementation = ProfesorDTO.class)))
            @ModelAttribute Profesor profesor) {
        profesorService.registrarProfesor(profesor);
        return "redirect:/profesores/registro";
    }
}