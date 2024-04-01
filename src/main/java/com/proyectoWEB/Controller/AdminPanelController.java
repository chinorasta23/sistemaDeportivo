/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectoWEB.Controller;

import com.proyectoWEB.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.proyectoWEB.service.ServicioService;


@Controller
@RequestMapping("/admin")
public class AdminPanelController {
    
    
    @Autowired
    private ServicioService servicioService;
    
    @Autowired 
    private ProyectoService proyectoService;
    
    @GetMapping("/panel")
    public String panel(Model model){
        var servicios = servicioService.getServicios();
        var proyectos = proyectoService.getProyectos();
        
        model.addAttribute("servicios", servicios);
        model.addAttribute("proyectos", proyectos);
        
        
        return "/admin/panel";
    }
   
}
