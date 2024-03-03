/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectoWEB.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.proyectoWEB.service.ServicioService;

@Controller
@RequestMapping("/servicio")
public class ServicioController {
    
    
    @Autowired
    private ServicioService servicioService;
    
    @GetMapping("/listado")
    public String listado(Model model){
        var servicios = servicioService.getServicios(true);
        model.addAttribute("servicios", servicios);
        model.addAttribute("totalServicios", servicios.size());
        return "/servicio/listado";
    }
    
}
