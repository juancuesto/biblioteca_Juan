package biblioteca_postgreSQL.biblioteca_Juan.controller;

import biblioteca_postgreSQL.biblioteca_Juan.entity.Libro;
import biblioteca_postgreSQL.biblioteca_Juan.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Controlador REST para la entidad Libro.
 */
@RestController
@RequestMapping("</api/libros>")
public class LibroController {

    @Autowired
    private LibroService libroService;

    /**
     * Crea un nuevo libro.
     *
     * @param libro El libro a crear.
     * @return El libro creado.
     */
    @PostMapping
    public ResponseEntity<Libro> createLibro(@RequestBody Libro libro) {
        Libro savedLibro = libroService.saveLibro(libro);
        return ResponseEntity.ok(savedLibro);
    }

    /**
     * Obtiene un libro por su ID.
     *
     * @param id El ID del libro.
     * @return El libro encontrado, o ResponseEntity.notFound() si no se encuentra.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Libro> getLibroById(@PathVariable UUID id) {
        Libro libro = libroService.getLibroById(id);
        return (libro != null) ? ResponseEntity.ok(libro) : ResponseEntity.notFound().build();
    }

    /**
     * Obtiene todos los libros.
     *
     * @return Lista de libros.
     */
    @GetMapping
    public ResponseEntity<List<Libro>> getAllLibros() {
        List<Libro> libros = libroService.getAllLibros();
        return ResponseEntity.ok(libros);
    }

    /**
     * Actualiza un libro existente.
     *
     * @param id El ID del libro a actualizar.
     * @param libro Los detalles del libro a actualizar.
     * @return El libro actualizado, o ResponseEntity.notFound() si no se encuentra.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Libro> updateLibro(@PathVariable UUID id, @RequestBody Libro libro) {
        Libro existingLibro = libroService.getLibroById(id);
        if (existingLibro != null) {
            libro.setId_libro(id); // Asegura que el ID del libro sea correcto
            Libro updatedLibro = libroService.saveLibro(libro);
            return ResponseEntity.ok(updatedLibro);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Elimina un libro por su ID.
     *
     * @param id El ID del libro a eliminar.
     * @return ResponseEntity.noContent() si se elimina correctamente, o ResponseEntity.notFound() si no se encuentra.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLibro(@PathVariable UUID id) {
        Libro existingLibro = libroService.getLibroById(id);
        if (existingLibro != null) {
            libroService.deleteLibro(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
