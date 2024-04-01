/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyectoWEB.dao;

import com.proyectoWEB.domain.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProyectoDao extends JpaRepository < Proyecto, Long> {

}
