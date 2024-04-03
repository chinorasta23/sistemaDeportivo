/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectoWEB.Controller;

import com.proyectoWEB.domain.Producto;
import com.proyectoWEB.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.proyectoWEB.service.ProductoService;
import com.proyectoWEB.service.impl.FirebaseStorageServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/admin")
public class AdminProductoController {
    
    
    @Autowired
    private ProductoService productoService;
    
    @Autowired
    private CategoriaService categoriaService;
    
    @GetMapping("/productos")
    public String listado(Model model){
        var productos = productoService.getProductos(false);
        var categorias = categoriaService.getCategorias();
        model.addAttribute("productos", productos);
        model.addAttribute("categorias", categorias);
        return "/admin/productos";
    }
    
    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageImpl;
    
    @PostMapping("/productos/guardar")
    public String guardar(Producto producto, @RequestParam("imagenFile") MultipartFile imagenFile){
        if (!imagenFile.isEmpty()) {
            productoService.saveProducto(producto);
            producto.setImgurl(firebaseStorageImpl.cargaImagen(imagenFile, "producto", producto.getIdProducto()));
        }
        productoService.saveProducto(producto);
        return "redirect:/admin/productos";
    }
    
    @GetMapping("/productos/eliminar/{idProducto}")
    public String elimina(Producto producto) {
        productoService.deleteProducto(producto);
        
        return "redirect:/admin/productos";
    }
    
    @GetMapping("/productos/modificar/{idProducto}")
    public String modifica(Producto producto, Model model) {
        producto = productoService.getProducto(producto);
        var categorias = categoriaService.getCategorias();
        
        model.addAttribute("producto", producto);
        model.addAttribute("categorias", categorias);
        
        return "/admin/modifica_productos";
    }
    
}
