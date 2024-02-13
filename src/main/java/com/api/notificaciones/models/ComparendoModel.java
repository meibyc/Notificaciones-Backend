package com.api.notificaciones.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "comparendo")
public class ComparendoModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comparendo")
    private Long idComparendo;
    @Column(name = "id_Persona")
    private Long idPersona;
    @Column(name = "numero_comparendo")
    private String numeroComparendo;
    @Column(name = "valor")
    private String valor;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "fecha_comparendo")
    private Date fechaComparendo;
    @Column(name = "fecha_notificacion")
    private Date fechaNotificacion;
}