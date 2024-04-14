/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectoWEB.controller;

import com.proyectoWEB.domain.Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.proyectoWEB.service.ServicioService;
import com.proyectoWEB.service.impl.FirebaseStorageServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/servicio")
public class ServicioController {
    
    
    @Autowired
    private ServicioService servicioService;
    
    @GetMapping("/listado")
    public String listado(Model model){
        var servicios = servicioService.getServicios();
        model.addAttribute("servicios", servicios);
        return "/servicio/listado";
    }
    
    @GetMapping("/verServicio/{idServicio}")
    public String verServicio(Servicio servicio, Model model) {
        servicio = servicioService.getServicio(servicio);
        model.addAttribute("servicio", servicio);
        return "/servicio/verServicio";
    }
    
}
