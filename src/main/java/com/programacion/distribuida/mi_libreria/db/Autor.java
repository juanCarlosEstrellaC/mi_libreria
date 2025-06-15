package com.programacion.distribuida.mi_libreria.db;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@Data
@EqualsAndHashCode(exclude = "libros")
@Entity
@Table(name = "autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "autor_id")
    private Long id;

    @Column(name = "autor_nombre")
    private String nombre;

    @Column(name = "autor_version")
    private Integer version;

    @ManyToMany(mappedBy = "autores", cascade = CascadeType.ALL)
    private Set<Libro> libros;

}
