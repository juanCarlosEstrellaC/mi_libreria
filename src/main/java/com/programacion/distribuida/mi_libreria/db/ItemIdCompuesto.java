package com.programacion.distribuida.mi_libreria.db;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class ItemIdCompuesto implements Serializable {

    private Long id;
    private Long ordenId;
}
