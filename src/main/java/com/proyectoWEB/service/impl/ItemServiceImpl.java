/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectoWEB.service.impl;

import com.proyectoWEB.dao.FacturaDao;
import com.proyectoWEB.dao.ProductoDao;
import com.proyectoWEB.dao.VentaDao;
import com.proyectoWEB.domain.Factura;
import com.proyectoWEB.service.ItemService;
import com.proyectoWEB.domain.Item;
import com.proyectoWEB.domain.Producto;
import com.proyectoWEB.domain.Usuario;
import com.proyectoWEB.domain.Venta;
import com.proyectoWEB.service.UsuarioService;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    @Override
    public List<Item> gets() {
        return listaItems;
    }

    @Override
    public Item get(Item item) {
        for (Item i : listaItems) {
            if (i.getIdProducto() == item.getIdProducto()) {
                return i;
            }
        }
        return null;
    }

    @Override
    public void delete(Item item) {
        var posicion = -1;
        var existe = false;
        
        for (Item i : listaItems) {
            posicion++;
            if (i.getIdProducto() == item.getIdProducto()) {
                existe=true;
                break;
            }
        }
        if (existe) {
            listaItems.remove(posicion);
        }
    }

    @Override
    public void save(Item item) {
        var existe = false;
        
        for (Item i : listaItems) {
            if (i.getIdProducto() == item.getIdProducto()) {
                existe=true;
                i.setCantidad(i.getCantidad() + 1);
                break;
            }
        }
        if (!existe) {
            item.setCantidad(1);
            listaItems.add(item);
        }    
    }

    @Override
    public void update(Item item) {
        for (Item i : listaItems) {
            if (Objects.equals(i.getIdProducto(), item.getIdProducto())) {
                i.setCantidad(item.getCantidad());
                break;
            }
        }
    }
    
    @Autowired 
    private UsuarioService usuarioService;
    
    @Autowired
    private FacturaDao facturaDao;
    
    @Autowired
    private VentaDao ventaDao;
    
    @Autowired
    private ProductoDao productoDao;
    
    @Override
    public void facturar() {
        String username;
        Object principal = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        if (principal instanceof UserDetails userDetails) {
            username = userDetails.getUsername();
        } else {
            username = principal.toString();
        }
        if (username.isBlank()) {
            return;
        }
        Usuario usuario = usuarioService.getUsuarioPorUsername(username);
        if (usuario == null) {
            return;
        }
        Factura factura = new Factura(usuario.getIdUsuario());
        factura = facturaDao.save(factura);
        double total = 0;
        
        for (Item i : listaItems) {
            System.out.println("Producto: " + i.getDescripcion()
                            + " Cantidad: " + i.getCantidad()
                            + " Total: " + i.getPrecio() * i.getCantidad());
            Venta venta = new Venta(factura.getIdFactura(), 
                    i.getIdProducto(), 
                    i.getPrecio(), i.getCantidad());
            ventaDao.save(venta);
            Producto producto = productoDao.getReferenceById(i.getIdProducto());
            producto.setExistencias(producto.getExistencias()-i.getCantidad());
            productoDao.save(producto);
            total += i.getPrecio() * i.getCantidad();
        }
        factura.setTotal(total);
        facturaDao.save(factura);
        listaItems.clear();
        
    }
    
    
}
