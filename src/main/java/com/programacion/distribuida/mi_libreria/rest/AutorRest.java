package com.programacion.distribuida.mi_libreria.rest;

import com.programacion.distribuida.mi_libreria.db.Autor;
import com.programacion.distribuida.mi_libreria.db.Libro;
import com.programacion.distribuida.mi_libreria.repository.IAutorRepository;
import com.programacion.distribuida.mi_libreria.repository.ILibroRepository;
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

    @Autowired
    private ILibroRepository libroRepository;

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
        return autorRepository.findById(id).map(autorExistente -> {
            autorExistente.setNombre(autor.getNombre());
            autorExistente.setVersion(autor.getVersion());

            // Limpiar libros actuales
            autorExistente.getLibros().clear();

            // Asociar nuevos libros
            if (autor.getLibros() != null) {
                for (Libro libro : autor.getLibros()) {
                    // Recuperar libro gestionado
                    Libro libroBD = libroRepository.findById(libro.getId()).orElse(null);
                    if (libroBD != null) {
                        autorExistente.getLibros().add(libroBD);
                        libroBD.getAutores().add(autorExistente); // sincronizar lado inverso
                    }
                }
            }

            autorRepository.save(autorExistente);
            return ResponseEntity.ok(autorExistente);
        }).orElse(ResponseEntity.notFound().build());
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
