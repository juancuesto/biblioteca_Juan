package biblioteca_postgreSQL.biblioteca_Juan.controller;

import biblioteca_postgreSQL.biblioteca_Juan.entity.Autor;
import biblioteca_postgreSQL.biblioteca_Juan.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Controlador REST para la entidad Autor.
 */
@RestController
@RequestMapping("/api/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    /**
     * Crea un nuevo autor.
     *
     * @param autor El autor a crear.
     * @return El autor creado.
     */
    @PostMapping
    public ResponseEntity<Autor> createAutor(@RequestBody Autor autor) {
        Autor savedAutor = autorService.saveAutor(autor);
        return ResponseEntity.ok(savedAutor);
    }

    /**
     * Obtiene un autor por su ID.
     *
     * @param id El ID del autor.
     * @return El autor encontrado, o ResponseEntity.notFound() si no se encuentra.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Autor> getAutorById(@PathVariable UUID id) {
        Autor autor = autorService.getAutorById(id);
        return (autor != null) ? ResponseEntity.ok(autor) : ResponseEntity.notFound().build();
    }

    /**
     * Obtiene todos los autores.
     *
     * @return Lista de autores.
     */
    @GetMapping
    public ResponseEntity<List<Autor>> getAllAutores() {
        List<Autor> autores = autorService.getAllAutores();
        return ResponseEntity.ok(autores);
    }

    /**
     * Actualiza un autor existente.
     *
     * @param id El ID del autor a actualizar.
     * @param autor Los detalles del autor a actualizar.
     * @return El autor actualizado, o ResponseEntity.notFound() si no se encuentra.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Autor> updateAutor(@PathVariable UUID id, @RequestBody Autor autor) {
        Autor existingAutor = autorService.getAutorById(id);
        if (existingAutor != null) {
            autor.setId_autor(id);  // Asegura que el ID del autor sea correcto
            Autor updatedAutor = autorService.saveAutor(autor);
            return ResponseEntity.ok(updatedAutor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Elimina un autor por su ID.
     *
     * @param id El ID del autor a eliminar.
     * @return ResponseEntity.noContent() si se elimina correctamente, o ResponseEntity.notFound() si no se encuentra.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAutor(@PathVariable UUID id) {
        Autor existingAutor = autorService.getAutorById(id);
        if (existingAutor != null) {
            autorService.deleteAutor(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
