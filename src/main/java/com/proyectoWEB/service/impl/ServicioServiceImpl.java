/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectoWEB.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyectoWEB.dao.ServicioDao;
import com.proyectoWEB.domain.Servicio;
import com.proyectoWEB.service.ServicioService;

@Service
public class ServicioServiceImpl implements ServicioService {

    
    @Autowired
    private ServicioDao servicioDao;
    
    @Override
    public List<Servicio> getServicios(boolean activos) {
        return servicioDao.findAll();
    }
    
}
