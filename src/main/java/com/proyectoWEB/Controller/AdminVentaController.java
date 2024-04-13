/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectoWEB.Controller;

import com.proyectoWEB.domain.Factura;
import com.proyectoWEB.domain.Producto;
import com.proyectoWEB.domain.Usuario;
import com.proyectoWEB.domain.Venta;
import com.proyectoWEB.service.FacturaService;
import com.proyectoWEB.service.ProductoService;
import com.proyectoWEB.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.proyectoWEB.service.VentaService;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminVentaController {

    @Autowired
    private VentaService ventaService;
    
    @GetMapping("/ventas")
    public String listado(Model model){
        var ventas = ventaService.getVentas();
        model.addAttribute("ventas", ventas);
        
        
        return "/admin/ventas";
    }
    
    @Autowired
    private FacturaService facturaService;
    
    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private ProductoService productoService;
    
    @GetMapping("/verFactura/{idFactura}")
    public String verProducto(Factura factura, Usuario usuario, Model model){
        factura = facturaService.getFactura(factura);
        Long LidUsuario = factura.getIdUsuario();
        int idUsuario = Long.valueOf(LidUsuario).intValue();

        usuario = usuarioService.getUsuarioPorId(idUsuario);
        var ventas = ventaService.getVentas();
        List<Producto> productos = new ArrayList();
        
        for (Venta venta : ventas) {
            if (venta.getIdFactura() == factura.getIdFactura()) {
                Long LidProducto = venta.getIdProducto();
                int idProducto = Long.valueOf(LidProducto).intValue();
                Producto producto = productoService.getProductoPorId(idProducto);
                productos.add(producto);
            }
        }
        
        model.addAttribute("factura", factura);
        model.addAttribute("usuario", usuario);
        model.addAttribute("productos", productos);
        model.addAttribute("ventas", ventas);
        
        return "/admin/verFactura";
    }
    
}
