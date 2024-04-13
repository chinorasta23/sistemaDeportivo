/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectoWEB.service.impl;

import com.proyectoWEB.dao.FacturaDao;
import com.proyectoWEB.domain.Factura;
import com.proyectoWEB.service.FacturaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
@Service
public class FacturaServiceImpl implements FacturaService {

    
    @Autowired
    private FacturaDao facturaDao;
    
    @Override
    @Transactional(readOnly=true)
    public List<Factura> getFacturas() {
        var lista = facturaDao.findAll();
        return lista;
    }

    @Override
    public Factura getFactura(Factura factura) {
        return facturaDao.findById(factura.getIdFactura()).orElse(null);
    }


}
