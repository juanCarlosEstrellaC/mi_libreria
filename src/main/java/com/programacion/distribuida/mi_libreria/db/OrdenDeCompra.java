package com.programacion.distribuida.mi_libreria.db;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "ordenes_de_compra")
@Data
public class OrdenDeCompra {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "orden_id")
    private Long id;

    @Column(name = "orden_total")
    private Integer total;

    @Column(name = "orden_estado")
    private Integer estado;

    @Column(name = "orden_fecha_colocacion")
    private LocalDateTime fechaColocacion;

    @Column(name = "orden_fecha_entrega")
    private LocalDateTime fechaEntrega;

    @ManyToOne
    @JoinColumn(name = "orden_cliente", referencedColumnName = "clie_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "ordenDeCompra", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Item> listaItems;

}
