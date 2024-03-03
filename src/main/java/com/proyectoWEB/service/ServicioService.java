/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyectoWEB.service;

import com.proyectoWEB.domain.Servicio;
import java.util.List;

public interface ServicioService {
    //Se obtiene un arraylist de objetos tipo Servicios
    public List<Servicio> getServicios(boolean activos);
    
}
