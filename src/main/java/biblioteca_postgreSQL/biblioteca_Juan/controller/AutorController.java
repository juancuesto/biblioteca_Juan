package biblioteca_postgreSQL.biblioteca_Juan.controller;

import biblioteca_postgreSQL.biblioteca_Juan.entity.Autor;
import biblioteca_postgreSQL.biblioteca_Juan.error.BadRequestExcepcion;
import biblioteca_postgreSQL.biblioteca_Juan.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/autor")
public class AutorController {
    @Autowired
    private AutorService autorService;

    @PostMapping("/add")
    public ResponseEntity<?> crearAutor(@RequestBody Autor autor){
        return new ResponseEntity<>(autorService.crearAutor(autor), HttpStatus.CREATED);
    }
    @GetMapping("/getOne/{id}")
    public ResponseEntity<?> buscarAutorById(@PathVariable UUID id){
        return new ResponseEntity<>(autorService.buscarAutorById(id),HttpStatus.FOUND);
    }
    @GetMapping("/listar")
    public ResponseEntity<?> listarAutores(){
        return new ResponseEntity<>(autorService.listarAutores(),HttpStatus.FOUND);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> actualizarAutor(@RequestBody Autor autor,@PathVariable UUID id){
        return new ResponseEntity<>(autorService.actualizarAutor(autor,id),HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> borrarAutorById(@PathVariable UUID id){
        try{
            autorService.borrarAutorById(id);
            return new ResponseEntity<>("Autor borrado correctamente",HttpStatus.OK);
        }catch (Exception ex){
            throw new BadRequestExcepcion("Error al borrar el autor");
        }
    }
}
