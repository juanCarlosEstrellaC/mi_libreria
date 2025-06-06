package com.programacion.distribuida.mi_libreria.repository;

import com.programacion.distribuida.mi_libreria.db.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(path = "autor", collectionResourceRel = "autor")
public interface IAutorRepository extends JpaRepository<Autor, Long> { }
