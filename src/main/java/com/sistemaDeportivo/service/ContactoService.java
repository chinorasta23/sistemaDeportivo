/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sistemaDeportivo.service;

import jakarta.mail.MessagingException;
import org.springframework.ui.Model;

public interface ContactoService {
    
    public Model enviarMensaje(Model model, String nombre, String Telefono, String Correo, String asunto, String mensaje) throws MessagingException;
}
