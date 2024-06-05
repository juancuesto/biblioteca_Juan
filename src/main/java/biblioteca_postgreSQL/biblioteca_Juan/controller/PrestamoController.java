package biblioteca_postgreSQL.biblioteca_Juan.controller;

import biblioteca_postgreSQL.biblioteca_Juan.entity.Autor;
import biblioteca_postgreSQL.biblioteca_Juan.entity.Prestamo;
import biblioteca_postgreSQL.biblioteca_Juan.error.BadRequestExcepcion;
import biblioteca_postgreSQL.biblioteca_Juan.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/prestamo")
public class PrestamoController {
    @Autowired
    private PrestamoService prestamoService;

    @PostMapping("/add")
    public ResponseEntity<?> crearPrestamo(@RequestBody Prestamo prestamo){
        return new ResponseEntity<>(prestamoService.crearPrestamo(prestamo), HttpStatus.CREATED);
    }
    @GetMapping("/getOne/{id}")
    public ResponseEntity<?> buscarPrestamoById(@PathVariable UUID id){
        return new ResponseEntity<>(prestamoService.buscarPrestamoById(id),HttpStatus.FOUND);
    }
    @GetMapping("/listar")
    public ResponseEntity<?> listarPrestamos(){
        return new ResponseEntity<>(prestamoService.listarPrestamos(),HttpStatus.FOUND);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> actualizarPrestamo(@RequestBody Prestamo prestamo,@PathVariable UUID id){
        return new ResponseEntity<>(prestamoService.actualizarPrestamo(prestamo,id),HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> borrarPrestamoById(@PathVariable UUID id){
        try{
            prestamoService.borrarPrestamoById(id);
            return new ResponseEntity<>("Prestamo borrado correctamente",HttpStatus.OK);
        }catch (Exception ex){
            throw new BadRequestExcepcion("Error al borrar el presstamo");
        }
    }
}
