package biblioteca_postgreSQL.biblioteca_Juan.controller;

import biblioteca_postgreSQL.biblioteca_Juan.entity.Categoria;
import biblioteca_postgreSQL.biblioteca_Juan.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Controlador REST para la entidad Categoria.
 */
@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    /**
     * Crea una nueva categoría.
     *
     * @param categoria La categoría a crear.
     * @return La categoría creada.
     */
    @PostMapping
    public ResponseEntity<Categoria> createCategoria(@RequestBody Categoria categoria) {
        Categoria savedCategoria = categoriaService.saveCategoria(categoria);
        return ResponseEntity.ok(savedCategoria);
    }

    /**
     * Obtiene una categoría por su ID.
     *
     * @param id El ID de la categoría.
     * @return La categoría encontrada, o ResponseEntity.notFound() si no se encuentra.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> getCategoriaById(@PathVariable UUID id) {
        Categoria categoria = categoriaService.getCategoriaById(id);
        return (categoria != null) ? ResponseEntity.ok(categoria) : ResponseEntity.notFound().build();
    }

    /**
     * Obtiene todas las categorías.
     *
     * @return Lista de categorías.
     */
    @GetMapping
    public ResponseEntity<List<Categoria>> getAllCategorias() {
        List<Categoria> categorias = categoriaService.getAllCategorias();
        return ResponseEntity.ok(categorias);
    }

    /**
     * Actualiza una categoría existente.
     *
     * @param id El ID de la categoría a actualizar.
     * @param categoria Los detalles de la categoría a actualizar.
     * @return La categoría actualizada, o ResponseEntity.notFound() si no se encuentra.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Categoria> updateCategoria(@PathVariable UUID id, @RequestBody Categoria categoria) {
        Categoria existingCategoria = categoriaService.getCategoriaById(id);
        if (existingCategoria != null) {
            categoria.setId_categoria(id);  // Asegura que el ID de la categoría sea correcto
            Categoria updatedCategoria = categoriaService.saveCategoria(categoria);
            return ResponseEntity.ok(updatedCategoria);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Elimina una categoría por su ID.
     *
     * @param id El ID de la categoría a eliminar.
     * @return ResponseEntity.noContent() si se elimina correctamente, o ResponseEntity.notFound() si no se encuentra.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoria(@PathVariable UUID id) {
        Categoria existingCategoria = categoriaService.getCategoriaById(id);
        if (existingCategoria != null) {
            categoriaService.deleteCategoria(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
