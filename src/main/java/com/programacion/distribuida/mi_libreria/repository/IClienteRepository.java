package com.programacion.distribuida.mi_libreria.repository;

import com.programacion.distribuida.mi_libreria.db.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepository extends JpaRepository<Cliente, Long> { }
