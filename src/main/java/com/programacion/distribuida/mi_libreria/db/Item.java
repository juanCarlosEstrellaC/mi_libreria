package com.programacion.distribuida.mi_libreria.db;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "items")
public class Item {

    @EmbeddedId
    private ItemIdCompuesto idCompuesto;

    @ManyToOne
    @MapsId("libroId")
    @JoinColumn(name = "item_libro_id", referencedColumnName = "libro_id")
    private Libro libro;

    @ManyToOne
    @MapsId("ordenCompraId")
    @JoinColumn(name = "item_orden_id", referencedColumnName = "orden_id")
    private OrdenDeCompra ordenDeCompra;

    @Column(name = "item_cantidad")
    private Integer cantidad;

}
