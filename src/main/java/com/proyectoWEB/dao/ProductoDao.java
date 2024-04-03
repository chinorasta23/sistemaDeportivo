/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyectoWEB.dao;

import com.proyectoWEB.domain.Producto;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoDao extends JpaRepository < Producto, Long> {
    
    public List<Producto> findByNombreContainingOrDescripcionContaining(String busqueda, String descripcion);
}
