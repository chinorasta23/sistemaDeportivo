/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistemaDeportivo.Controller;

import com.sistemaDeportivo.domain.Usuario;
import com.sistemaDeportivo.service.RegistroService;
import com.sistemaDeportivo.service.UsuarioService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;



@Controller
public class PerfilController {

    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping("/usuario/perfil/{idUsuario}")
    public String verProducto(@PathVariable("idUsuario") Long idUsuario, Model model){
        
        long idUsuarioL = idUsuario;
        int idUsuarioI = (int) idUsuarioL;
        
        Usuario usuario = usuarioService.getUsuarioPorId(idUsuarioI);

        model.addAttribute("usuario", usuario);
        
        return "/usuario/perfil";
    }
    
    @Autowired
    private RegistroService registroService;
    
    @PostMapping("/usuario/perfil/actualizar")
    public String recordarUsuario(Model model, Usuario usuario, @RequestParam("imagenFile") MultipartFile imagenFile) 
            throws MessagingException {
        registroService.actualizar(usuario, imagenFile);
        return "/usuario/perfil";
    }
    
}
