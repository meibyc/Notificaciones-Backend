package com.api.notificaciones.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "derechos_de_transito")
public class DerechosModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_derechos_de_transito")
    private Long idDerechosDeTransito;
    @Column(name = "id_Persona")
    private Long idPersona;
    @Column(name = "vigencia")
    private String vigencia;
    @Column(name = "valor")
    private String valor;
    @Column(name = "placa_vehiculo")
    private String placaVehiculo;
}