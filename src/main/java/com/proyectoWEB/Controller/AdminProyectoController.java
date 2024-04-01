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
import com.proyectoWEB.service.impl.FirebaseStorageServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/admin")
public class AdminProyectoController {
    
    
    @Autowired
    private ProyectoService proyectoService;
    
    @GetMapping("/proyectos")
    public String listado(Model model){
        var proyectos = proyectoService.getProyectos();
        model.addAttribute("proyectos", proyectos);
        return "/admin/proyectos";
    }
    
    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageImpl;
    
    @PostMapping("/proyectos/guardar")
    public String guardar(Proyecto proyecto, @RequestParam("imagenFile") MultipartFile imagenFile){
        if (!imagenFile.isEmpty()) {
            proyectoService.saveProyecto(proyecto);
            proyecto.setImgurl(firebaseStorageImpl.cargaImagen(imagenFile, "proyecto", proyecto.getIdProyecto()));
        }
        proyectoService.saveProyecto(proyecto);
        return "redirect:/admin/proyectos";
    }
    
    @GetMapping("/proyectos/eliminar/{idProyecto}")
    public String elimina(Proyecto proyecto) {
        proyectoService.deleteProyecto(proyecto);
        
        return "redirect:/admin/proyectos";
    }
    
    @GetMapping("/proyectos/modificar/{idProyecto}")
    public String modifica(Proyecto proyecto, Model model) {
        proyecto = proyectoService.getProyecto(proyecto);
        model.addAttribute("proyecto", proyecto);
        return "/admin/modifica_proyectos";
    }
    
}
