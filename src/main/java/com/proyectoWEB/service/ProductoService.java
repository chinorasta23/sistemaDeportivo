/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyectoWEB.service;

import com.proyectoWEB.domain.Producto;
import java.util.List;

public interface ProductoService {

    public List<Producto> getProductos(boolean activos);

    public Producto getProducto(Producto producto);

    public void deleteProducto(Producto producto);

    public void saveProducto(Producto producto);

    public List<Producto> busqueda(String busqueda, String descripcion);
    
    public Producto getProductoPorId(int id);
}
