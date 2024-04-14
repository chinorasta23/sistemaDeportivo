/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectoWEB.Controller;

import com.proyectoWEB.service.ContactoService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/contacto")
public class ContactoController {

    @Autowired
    private ContactoService contactoService;
    
    @GetMapping("/form")
    public String formulario() throws MessagingException{
        return "/contacto/form";
    }
    
    @PostMapping("/enviar")
    public String enviar(Model model, @RequestParam("nombre") String nombre,@RequestParam("telefono") String telefono,@RequestParam("correo") String correo, @RequestParam("asunto") String asunto, @RequestParam("mensaje") String mensaje) throws MessagingException{
        contactoService.enviarMensaje(model, nombre, telefono, correo, asunto, mensaje);
        return "/contacto/form";
    }

    
}
