// package com.rollerspeed.v1.Controllers;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.validation.BindingResult;

// import com.rollerspeed.v1.Model.entity.Usuario;
// import com.rollerspeed.v1.security.IUsuarioService;

// import jakarta.validation.Valid;

// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PostMapping;



// @Controller
// public class LoginController {
    
//     @Autowired
//     private IUsuarioService usuarioService;
    
//     @GetMapping("/templates/registro")
//     public String registroForm(Model model) {
//         model.addAttribute("usuario", new Usuario());

//         return "registro";
//     }

//     @PostMapping("/templates/registro")
//     public String registro(@Valid @ModelAttribute Usuario usuario, BindingResult result, Model model) {

//         if (result.hasErrors()) {
//             return "redirect:/templates/registro";
//         }
//         else {
//             model.addAttribute("usuario", usuarioService.registrar(usuario));
//         }

//         return "redirect:/templates/registro";
//     }
// }

package com.rollerspeed.v1.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.rollerspeed.v1.Model.entity.Usuario;
import com.rollerspeed.v1.security.IUsuarioService;

import jakarta.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    private IUsuarioService usuarioService;

    // Muestra el formulario de registro
    @GetMapping("/auth/registro")
    public String registroForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "registro"; // Nombre de la vista (sin .html)
    }

    // Procesa el formulario de registro
    @PostMapping("/templates/registro")
    public String registro(@Valid @ModelAttribute Usuario usuario, BindingResult result, Model model) {
        if (result.hasErrors()) {
            // Si hay errores, vuelve a mostrar el formulario con mensajes de error
            return "registro";
        } else {
            // Registra al usuario y agrega el objeto registrado al modelo
            model.addAttribute("usuario", usuarioService.registrar(usuario));
        }
        // Redirige a otra página después de registrar correctamente
        return "redirect:/templates/registro"; // Cambia a la página de inicio de sesión
    }
}