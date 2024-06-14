package biblioteca_postgreSQL.biblioteca_Juan.controller;

import biblioteca_postgreSQL.biblioteca_Juan.entity.Categoria;
import biblioteca_postgreSQL.biblioteca_Juan.entity.Libro;
import biblioteca_postgreSQL.biblioteca_Juan.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/libros")
public class LibroController {
    @Autowired
    private LibroService libroService;


    @PostMapping
    public ResponseEntity<?> crearLibro(@RequestBody Libro libro) {
        return new ResponseEntity<>(libroService.saveLibro(libro), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getLibroById(@PathVariable UUID id) {
        Libro libro = libroService.getLibroById(id);
        if (libro != null) {
            return new ResponseEntity<>(libro, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>("No se ha encontrado la libro", HttpStatus.NOT_FOUND);
        }
        //return new ResponseEntity<>(libroService.getLibroById(id), HttpStatus.FOUND);
    }

    @GetMapping
    public ResponseEntity<?> getAllLibros() {
        return new ResponseEntity<>(libroService.getAllLibros(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarLibro(@RequestBody Libro libro, @PathVariable UUID id) {
        Libro libro1 = libroService.getLibroById(id);
        if (libro1 != null) {
            libro1.setId_libro(libro.getId_libro());
            return new ResponseEntity<>(libroService.saveLibro(libro1), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No se ha encontrado la libro a actualiazar", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLibroById(@PathVariable UUID id) {
        Libro libro = libroService.getLibroById(id);
        if (libro != null) {
            libroService.deleteLibroById(id);
            return new ResponseEntity<>("libro borrado correctamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No se ha encontrado el libro a borrar", HttpStatus.NOT_FOUND);
        }
    }
}