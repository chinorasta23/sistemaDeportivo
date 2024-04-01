package com.proyectoWEB.domain;


import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="proyecto")
public class Proyecto implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_proyecto")
    private Long idProyecto;
    private String titulo;
    private String descripcion;
    private String imgurl;
    
}
