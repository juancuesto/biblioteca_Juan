package biblioteca_postgreSQL.biblioteca_Juan.controller;

import biblioteca_postgreSQL.biblioteca_Juan.entity.Libro;
import biblioteca_postgreSQL.biblioteca_Juan.entity.Usuario;
import biblioteca_postgreSQL.biblioteca_Juan.error.BadRequestExcepcion;
import biblioteca_postgreSQL.biblioteca_Juan.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/libro")
public class LibroController {
    @Autowired
    private LibroService libroService;

    @PostMapping("/add")
    public ResponseEntity<?> crearLibro(@RequestBody Libro libro){
        return new ResponseEntity<>(libroService.crearLibro(libro), HttpStatus.CREATED);
    }
    @GetMapping("/getOne/{id}")
    public ResponseEntity<?> buscarLibroById(@PathVariable UUID id){
        return new ResponseEntity<>(libroService.buscarLibroById(id),HttpStatus.FOUND);
    }
    @GetMapping("/listar")
    public ResponseEntity<?> listarLibros(){
        return new ResponseEntity<>(libroService.listarLibros(),HttpStatus.FOUND);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> actualizarLibro(@RequestBody Libro libro,@PathVariable UUID id){
        return new ResponseEntity<>(libroService.actualizarLibro(libro,id),HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> borrarLibroById(@PathVariable UUID id){
        try{
            libroService.borrarLibroById(id);
            return new ResponseEntity<>("Libro borrado correctamente",HttpStatus.OK);
        }catch (Exception ex){
            throw new BadRequestExcepcion("Error al borrar el Libro");
        }
    }
}
