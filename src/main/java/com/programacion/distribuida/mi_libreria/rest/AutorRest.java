package com.programacion.distribuida.mi_libreria.rest;

import com.programacion.distribuida.mi_libreria.db.Autor;
import com.programacion.distribuida.mi_libreria.repository.IAutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autor")
public class AutorRest {

    @Autowired
    private IAutorRepository autorRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Autor>> buscarTodos() {
        return ResponseEntity.ok(this.autorRepository.findAll());
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Autor> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.autorRepository.findById(id).orElse(null));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Autor> guardar(@RequestBody Autor autor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.autorRepository.save(autor));
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Autor> actualizar(@PathVariable Long id, @RequestBody Autor autor) {
        if (this.autorRepository.existsById(id)) {
            autor.setId(id);
            return ResponseEntity.status(HttpStatus.OK).body(this.autorRepository.save(autor));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (this.autorRepository.existsById(id)) {
            this.autorRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
