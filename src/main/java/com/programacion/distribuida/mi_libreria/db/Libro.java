package com.programacion.distribuida.mi_libreria.db;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = "autores")
@Entity
@Table(name = "libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "libro_id")
    private Long id;

    @Column(name = "libro_titulo")
    private String titulo;

    @Column(name = "libro_precio")
    private Double precio;

    @Column(name = "libro_version")
    private Integer version;

    @OneToMany(mappedBy = "libro", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Item> listaItems;

    @ManyToMany
    @JoinTable(
        name = "libro_autor",
        joinColumns = @JoinColumn(name = "libro_id", referencedColumnName = "libro_id"),
        inverseJoinColumns = @JoinColumn(name = "autor_id", referencedColumnName = "autor_id")
    )
    private Set<Autor> autores;

    @OneToOne(mappedBy = "libro", cascade = CascadeType.ALL, orphanRemoval = true)
    private Inventario inventario;
}
