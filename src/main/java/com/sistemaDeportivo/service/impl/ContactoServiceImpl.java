/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistemaDeportivo.service.impl;

import com.sistemaDeportivo.service.ContactoService;
import com.sistemaDeportivo.service.CorreoService;
import jakarta.mail.MessagingException;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

 
@Service
public class ContactoServiceImpl implements ContactoService {

    @Autowired
    private CorreoService correoService;
    
    @Value("${servidor.http}")
    private String servidor;



    @Override
    public Model enviarMensaje(Model model, String nombre, String Telefono, String Correo, String asunto, String mensaje) throws MessagingException {
        String mensajeL = nombre + "\n" + Telefono + "\n" + Correo + "\n" + mensaje;
        enviaCorreoActivar(asunto, mensajeL);
        return model;
    }
    
    private void enviaCorreoActivar(String asunto, String mensaje) throws MessagingException {
        
        correoService.enviarCorreoHtml("doohansol@gmail.com", asunto, mensaje);
    }
}
