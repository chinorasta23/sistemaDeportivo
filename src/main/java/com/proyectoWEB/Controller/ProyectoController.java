/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectoWEB.Controller;

import com.proyectoWEB.domain.Proyecto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.proyectoWEB.service.ProyectoService;


@Controller
@RequestMapping("/proyectos")
public class ProyectoController {
    
    
    @Autowired
    private ProyectoService proyectoService;
    
    @GetMapping("/listado")
    public String listado(Model model){
        var proyectos = proyectoService.getProyectos();
        model.addAttribute("proyectos", proyectos);
        return "/proyectos/listado";
    }

    
}
