package biblioteca_postgreSQL.biblioteca_Juan.controller;

import biblioteca_postgreSQL.biblioteca_Juan.entity.Libro;
import biblioteca_postgreSQL.biblioteca_Juan.entity.Prestamo;
import biblioteca_postgreSQL.biblioteca_Juan.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/prestamos")
public class PrestamoController {
    @Autowired
    private PrestamoService prestamoService;

    @PostMapping
    public ResponseEntity<?> crearPrestamo(@RequestBody Prestamo prestamo) {
        return new ResponseEntity<>(prestamoService.savePrestamo(prestamo), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPrestamoById(@PathVariable UUID id) {
        Prestamo prestamo = prestamoService.getPrestamoById(id);
        if (prestamo != null) {
            return new ResponseEntity<>(prestamo, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>("No se ha encontrado el Prestamo", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllPrestamo() {
        return new ResponseEntity<>(prestamoService.getAllPrestamos(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarPrestamo(@RequestBody Prestamo prestamo, @PathVariable UUID id) {
        Prestamo prestamo1 = prestamoService.getPrestamoById(id);
        if (prestamo1 != null) {
            prestamo1.setId_prestamo(prestamo.getId_prestamo());
            return new ResponseEntity<>(prestamoService.savePrestamo(prestamo1), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No se ha encontrado el Prestamo a actualiazar", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLibroById(@PathVariable UUID id) {
        Prestamo prestamo=prestamoService.getPrestamoById(id);
        if (prestamo != null) {
            prestamoService.deletePrestamoById(id);
            return new ResponseEntity<>("Prestamo borrado correctamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No se ha encontrado el Prestamo a borrar", HttpStatus.NOT_FOUND);
        }
    }
}
