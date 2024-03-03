/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectoWEB.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author dooha
 */
public class MservicioController {
    @RequestMapping("/servicios")
    public String mostrarServicios() {
        return "mservicios";
    }
}
