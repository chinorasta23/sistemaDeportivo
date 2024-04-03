/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyectoWEB.service;

import com.proyectoWEB.domain.Categoria;
import java.util.List;

public interface CategoriaService {

    public List<Categoria> getCategorias();

    public Categoria getCategoria(Categoria categoria);

    public void deleteCategoria(Categoria categoria);

    public void saveCategoria(Categoria categoria);
    
}
