package com.programacion.distribuida.mi_libreria.db;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "clie_id")
    private Long id;

    @Column(name = "clie_nombre")
    private String nombre;

    @Column(name = "clie_email")
    private String email;

    @Column(name = "clie_version")
    private Integer version;

    @OneToMany(mappedBy = "cliente")
    private List<OrdenDeCompra> ordenesDeCompra;

}
