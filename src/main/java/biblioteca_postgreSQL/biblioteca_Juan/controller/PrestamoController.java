package biblioteca_postgreSQL.biblioteca_Juan.controller;

import biblioteca_postgreSQL.biblioteca_Juan.entity.Prestamo;
import biblioteca_postgreSQL.biblioteca_Juan.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Controlador REST para la entidad Prestamo.
 */
@RestController
@RequestMapping("/api/prestamos")
public class PrestamoController {

    @Autowired
    private PrestamoService prestamoService;

    /**
     * Crea un nuevo préstamo.
     *
     * @param prestamo El préstamo a crear.
     * @return El préstamo creado.
     */
    @PostMapping
    public ResponseEntity<Prestamo> createPrestamo(@RequestBody Prestamo prestamo) {
        Prestamo savedPrestamo = prestamoService.savePrestamo(prestamo);
        return ResponseEntity.ok(savedPrestamo);
    }

    /**
     * Obtiene un préstamo por su ID.
     *
     * @param id El ID del préstamo.
     * @return El préstamo encontrado, o ResponseEntity.notFound() si no se encuentra.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Prestamo> getPrestamoById(@PathVariable UUID id) {
        Prestamo prestamo = prestamoService.getPrestamoById(id);
        return (prestamo != null) ? ResponseEntity.ok(prestamo) : ResponseEntity.notFound().build();
    }

    /**
     * Obtiene todos los préstamos.
     *
     * @return Lista de préstamos.
     */
    @GetMapping
    public ResponseEntity<List<Prestamo>> getAllPrestamos() {
        List<Prestamo> prestamos = prestamoService.getAllPrestamos();
        return ResponseEntity.ok(prestamos);
    }

    /**
     * Actualiza un préstamo existente.
     *
     * @param id El ID del préstamo a actualizar.
     * @param prestamo Los detalles del préstamo a actualizar.
     * @return El préstamo actualizado, o ResponseEntity.notFound() si no se encuentra.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Prestamo> updatePrestamo(@PathVariable UUID id, @RequestBody Prestamo prestamo) {
        Prestamo existingPrestamo = prestamoService.getPrestamoById(id);
        if (existingPrestamo != null) {
            prestamo.setId_prestamo(id); // Asegura que el ID del préstamo sea correcto
            Prestamo updatedPrestamo = prestamoService.savePrestamo(prestamo);
            return ResponseEntity.ok(updatedPrestamo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Elimina un préstamo por su ID.
     *
     * @param id El ID del préstamo a eliminar.
     * @return ResponseEntity.noContent() si se elimina correctamente, o ResponseEntity.notFound() si no se encuentra.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrestamo(@PathVariable UUID id) {
        Prestamo existingPrestamo = prestamoService.getPrestamoById(id);
        if (existingPrestamo != null) {
            prestamoService.deletePrestamo(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
