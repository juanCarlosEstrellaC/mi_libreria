package com.programacion.distribuida.mi_libreria.db;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "inventarios")
public class Inventario {

    @Id
    @OneToOne
    @JoinColumn(name = "libro_id", referencedColumnName = "libro_id")
    private Libro libro;

    @Column(name = "inve_vendidos")
    private Integer vendidos;

    @Column(name = "inve_suministrados")
    private Integer suministrados;

    @Column(name = "inve_version")
    private Integer version;

}
