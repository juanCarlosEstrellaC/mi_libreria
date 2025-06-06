package com.programacion.distribuida.mi_libreria.repository;

import com.programacion.distribuida.mi_libreria.db.OrdenDeCompra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrdenDeCompraRepository extends JpaRepository<OrdenDeCompra, Long> { }
