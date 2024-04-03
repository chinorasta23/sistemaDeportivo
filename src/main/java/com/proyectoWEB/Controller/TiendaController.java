/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectoWEB.Controller;

import com.proyectoWEB.domain.Categoria;
import com.proyectoWEB.domain.Producto;
import com.proyectoWEB.service.CategoriaService;
import com.proyectoWEB.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/tienda")
public class TiendaController {
    
    
    @Autowired
    private ProductoService productoService;
    
    @Autowired
    private CategoriaService categoriaService;
    
    @GetMapping("/productos")
    public String productosTienda(Model model){
        var productos = productoService.getProductos(true);
        var categorias = categoriaService.getCategorias();
        
        model.addAttribute("productos", productos);
        model.addAttribute("categorias", categorias);
        
        return "/tienda/productos";
    }
    
    @GetMapping("/productos/{idCategoria}")
    public String productosCategoria(Categoria categoria, Model model){
        categoria = categoriaService.getCategoria(categoria);
        var productos = categoria.getProductos();
        var categorias = categoriaService.getCategorias();
        
        model.addAttribute("categorias", categorias);
        model.addAttribute("productos", productos);
        model.addAttribute("totalCategorias", categorias.size());
        model.addAttribute("totalProductos", productos.size());
        
        return "/tienda/productos";
    }
    
    @GetMapping("/producto/{idProducto}")
    public String verProducto(Producto producto, Model model){
        producto = productoService.getProducto(producto);

        model.addAttribute("producto", producto);
        
        return "/tienda/producto";
    }
    
    
    @PostMapping("/busqueda")
    public String consultaQuery1(
            @RequestParam(value="nombre") String nombre, Model model){
        
        var productos = productoService.busqueda(nombre, nombre);
        model.addAttribute("productos", productos);
        model.addAttribute("nombre", nombre);
        
        return "/tienda/busqueda";
    }
}
