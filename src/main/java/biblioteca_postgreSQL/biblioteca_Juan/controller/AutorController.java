package biblioteca_postgreSQL.biblioteca_Juan.controller;

import biblioteca_postgreSQL.biblioteca_Juan.entity.Autor;
import biblioteca_postgreSQL.biblioteca_Juan.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/autores")
public class AutorController {
    @Autowired
    private AutorService autorService;

    @PostMapping
    public ResponseEntity<?> crearAutor(@RequestBody Autor autor){
        return new ResponseEntity<>(autorService.saveAutor(autor), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getAutorById(@PathVariable UUID id){
        Autor autor1=autorService.getAutorById(id);
        if (autor1!=null){
            return new ResponseEntity<>(autor1,HttpStatus.FOUND);
        }else {
            return new ResponseEntity<>("No se ha encontrado el autor",HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping
    public ResponseEntity<?> listarAutores(){
        return new ResponseEntity<>(autorService.getAllAutores(),HttpStatus.FOUND);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarAutor(@RequestBody Autor autor,@PathVariable UUID id){
        Autor autor1=autorService.getAutorById(id);
        if (autor1!=null){
            autor.setId_autor(id); // asugura que el ID del autor sea correcto
            return new ResponseEntity<>(autorService.saveAutor(autor),HttpStatus.OK);
        }else {
            return new ResponseEntity<>("No se ha encontrado el autor a actualizar",HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAutorById(@PathVariable UUID id){
        Autor autor1=autorService.getAutorById(id);
        if (autor1!=null){
            autorService.deleteAutorById(id);
            return new ResponseEntity<>("Autor borrado correctamentes",HttpStatus.OK);
        }else {
            return new ResponseEntity<>("No se ha encontrado el autor a borrar",HttpStatus.NOT_FOUND);
        }
    }
}
