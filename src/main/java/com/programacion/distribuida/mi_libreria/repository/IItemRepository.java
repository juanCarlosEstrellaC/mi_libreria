package com.programacion.distribuida.mi_libreria.repository;

import com.programacion.distribuida.mi_libreria.db.Item;
import com.programacion.distribuida.mi_libreria.db.ItemIdCompuesto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IItemRepository extends JpaRepository<Item, ItemIdCompuesto> {
}
