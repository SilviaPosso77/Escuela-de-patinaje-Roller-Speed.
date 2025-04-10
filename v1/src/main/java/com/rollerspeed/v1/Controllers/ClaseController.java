package com.rollerspeed.v1.Controllers;

import com.rollerspeed.v1.DTO.ClaseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rollerspeed.v1.Service.ClaseServicio;
import com.rollerspeed.v1.Model.Clase;

@Service 
@Tag(name="Clases", description = "Operaciones sobre crear y listar las clases")
@Controller
@RequestMapping("/clases")
public class ClaseController {

    @Autowired
    ClaseServicio claseServicio;

    @GetMapping("/horario")
    @Operation(
            summary = "Creación y Listar clases",
            description = "Listar las clases inscritas",
            responses = {
            @ApiResponse( responseCode = "200", description = "Se ha obtenido la lista de clases",
                content = @Content(schema = @Schema(implementation = ClaseDTO.class))),
            @ApiResponse(responseCode = "500", description = "Error obteniendo la lista de clases")
    })
    public String listaClases(Model modelo) {
        modelo.addAttribute("clases",claseServicio.listarTodasLasClases());
        return "Horarios/horario1";
    }

    @GetMapping("/registro")
    @Operation(
            summary = "Envio de modelo",
            description = "Creacion de una nueva clase"
    )
    public String formularioRegistro(Model modelo) {
        modelo.addAttribute("clase", new Clase());
        return "Clases/registro_clases";
    }

    @PostMapping("/registro")
    @Operation(
            summary = "Registrar Clase",
            description = "Recibe una nueva clase y la guarda en la base de datos"
    )
    public String registrarClase(
            @Parameter(description = "Datos de la clase a registrar.", required = true, content = @Content(schema = @Schema(implementation = ClaseDTO.class)))
            @ModelAttribute Clase clase){
        claseServicio.registrarClase(clase);
        return "redirect:/clases/registro";
    }

    @GetMapping("/editar/{id}")
    @Operation(
        summary = "Editar datos clase",
        description = "Busca los datos de un clase por Id y lo envia para su edicion"
    )
    public String editarClase(@PathVariable int id, Model model){
        model.addAttribute("clase", claseServicio.ObtenerId(id));
        return "Clases/editar_clases";
    }

    @PostMapping("/{id}")
    @Operation(
        summary = "Actualizar clase",
        description = "Recibe los nuevos datos de una clase y los actualiza"
    )
    public String actualizarClase(@PathVariable int id, @ModelAttribute("clase") Clase datosNuevos){
        Clase datosAntiguos = claseServicio.ObtenerId(id);
        claseServicio.ActualizarClase(datosAntiguos, datosNuevos);
        return "redirect:/clases/horario";
    }
    
}
