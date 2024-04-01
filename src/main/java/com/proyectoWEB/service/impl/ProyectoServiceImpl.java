/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectoWEB.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyectoWEB.dao.ProyectoDao;
import com.proyectoWEB.domain.Proyecto;
import com.proyectoWEB.service.ProyectoService;

@Service
public class ProyectoServiceImpl implements ProyectoService {

    
    @Autowired
    private ProyectoDao proyectoDao;
    
    @Override
    public List<Proyecto> getProyectos() {
        return proyectoDao.findAll();
    }

    @Override
    public Proyecto getProyecto(Proyecto proyecto) {
       return proyectoDao.findById(proyecto.getIdProyecto()).orElse(null);
    }

    @Override
    public void deleteProyecto(Proyecto proyecto) {
        proyectoDao.delete(proyecto);
    }

    @Override
    public void saveProyecto(Proyecto proyecto) {
        proyectoDao.save(proyecto);
    }
    
}
