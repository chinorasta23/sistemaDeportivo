/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectoWEB.Controller;

import com.proyectoWEB.service.CategoriaService;
import com.proyectoWEB.service.FacturaService;
import com.proyectoWEB.service.ProductoService;
import com.proyectoWEB.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.proyectoWEB.service.ServicioService;
import com.proyectoWEB.service.VentaService;


@Controller
@RequestMapping("/admin")
public class AdminPanelController {
    
    
    @Autowired
    private ServicioService servicioService;
    
    @Autowired 
    private ProyectoService proyectoService;
    
    @Autowired
    private VentaService ventaService;
    
    @Autowired
    private FacturaService facturaService;
    
    @Autowired
    private ProductoService productoService;
    
    @Autowired
    private CategoriaService categoriaService;
    
    @GetMapping("/panel")
    public String panel(Model model){
        var servicios = servicioService.getServicios();
        var proyectos = proyectoService.getProyectos();
        var ventas = ventaService.getVentas();
        var facturas = facturaService.getFacturas();
        var productos = productoService.getProductos(true);
        var categorias = categoriaService.getCategorias();
        
        model.addAttribute("servicios", servicios);
        model.addAttribute("proyectos", proyectos);
        model.addAttribute("facturas", facturas);
        model.addAttribute("ventas", ventas);
        model.addAttribute("totalVentas", ventas.size());
        model.addAttribute("productos", productos);
        model.addAttribute("totalProductos", productos.size());
        model.addAttribute("categorias", categorias);
        
        return "/admin/panel";
    }
   
}
