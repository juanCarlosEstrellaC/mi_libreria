package com.programacion.distribuida.mi_libreria.db;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "items")
public class Item {

    // Creo que falta asignar el valor de id a la columna item_id_compuesto!

    @EmbeddedId
    private ItemIdCompuesto idCompuesto;

    @ManyToOne
    @MapsId("ordenId")
    @JoinColumn(name = "item_orden_id", referencedColumnName = "orden_id")
    private OrdenDeCompra ordenDeCompra;

    @Column(name = "item_cantidad")
    private Integer cantidad;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "item_libro_id", referencedColumnName = "libro_id")
    private Libro libro;

}
