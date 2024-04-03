/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectoWEB.Controller;

import com.proyectoWEB.domain.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.proyectoWEB.service.CategoriaService;
import com.proyectoWEB.service.impl.FirebaseStorageServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/admin")
public class AdminCategoriaController {
    
    
    @Autowired
    private CategoriaService categoriaService;
    
    @GetMapping("/categorias")
    public String listado(Model model){
        var categorias = categoriaService.getCategorias();
        model.addAttribute("categorias", categorias);
        return "/admin/categorias";
    }
    
    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageImpl;
    
    @PostMapping("/categorias/guardar")
    public String guardar(Categoria categoria, @RequestParam("imagenFile") MultipartFile imagenFile){
        if (!imagenFile.isEmpty()) {
            categoriaService.saveCategoria(categoria);
            categoria.setImgurl(firebaseStorageImpl.cargaImagen(imagenFile, "categoria", categoria.getIdCategoria()));
        }
        categoriaService.saveCategoria(categoria);
        return "redirect:/admin/categorias";
    }
    
    @GetMapping("/categorias/eliminar/{idCategoria}")
    public String elimina(Categoria categoria) {
        categoriaService.deleteCategoria(categoria);
        
        return "redirect:/admin/categorias";
    }
    
    @GetMapping("/categorias/modificar/{idCategoria}")
    public String modifica(Categoria categoria, Model model) {
        categoria = categoriaService.getCategoria(categoria);
        model.addAttribute("categoria", categoria);
        return "/admin/modifica_categorias";
    }
    
}
