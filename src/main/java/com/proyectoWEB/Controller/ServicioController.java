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
        model.addAttribute("totalServicios", servicios.size());
        return "/servicio/listado";
    }
    
    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageImpl;
    
    @PostMapping("/guardar")
    public String guardar(Servicio servicio, @RequestParam("imagenFile") MultipartFile imagenFile){
        if (!imagenFile.isEmpty()) {
            servicioService.saveServicio(servicio);
            servicio.setImgurl(firebaseStorageImpl.cargaImagen(imagenFile, "servicio", servicio.getIdServicio()));
        }
        servicioService.saveServicio(servicio);
        return "redirect:/servicio/listado";
    }
    
    @GetMapping("/eliminar/{idServicio}")
    public String elimina(Servicio servicio) {
        servicioService.deleteServicio(servicio);
        
        return "redirect:/servicio/listado";
    }
    
    @GetMapping("/modificar/{idServicio}")
    public String modifica(Servicio servicio, Model model) {
        servicio = servicioService.getServicio(servicio);
        model.addAttribute("servicio", servicio);
        return "/servicio/modifica";
    }
    
}
