package com.programacion.distribuida.mi_libreria.repository;

import com.programacion.distribuida.mi_libreria.db.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILibroRepository extends JpaRepository<Libro, Long> { }
