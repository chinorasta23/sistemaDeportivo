/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyectoWEB.service;

import com.proyectoWEB.domain.Proyecto;
import java.util.List;

public interface ProyectoService {

    public List<Proyecto> getProyectos();
    
    public Proyecto getProyecto(Proyecto proyecto);

    public void deleteProyecto(Proyecto proyecto);
    
    public void saveProyecto(Proyecto proyecto);
    
}
