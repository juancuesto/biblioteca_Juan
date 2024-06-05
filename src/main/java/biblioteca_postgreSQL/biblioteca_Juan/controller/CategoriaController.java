package biblioteca_postgreSQL.biblioteca_Juan.controller;

import biblioteca_postgreSQL.biblioteca_Juan.entity.Autor;
import biblioteca_postgreSQL.biblioteca_Juan.entity.Categoria;
import biblioteca_postgreSQL.biblioteca_Juan.error.BadRequestExcepcion;
import biblioteca_postgreSQL.biblioteca_Juan.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping("/add")
    public ResponseEntity<?> crearCategoria(@RequestBody Categoria categoria){
        return new ResponseEntity<>(categoriaService.crearCategoria(categoria), HttpStatus.CREATED);
    }
    @GetMapping("/getOne/{id}")
    public ResponseEntity<?> buscarCategoriaById(@PathVariable UUID id){
        return new ResponseEntity<>(categoriaService.buscarCategoriaById(id),HttpStatus.FOUND);
    }
    @GetMapping("/listar")
    public ResponseEntity<?> listarCategorias(){
        return new ResponseEntity<>(categoriaService.listarCategorias(),HttpStatus.FOUND);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> actualizarCategoria(@RequestBody Categoria categoria,@PathVariable UUID id){
        return new ResponseEntity<>(categoriaService.actualizarCategoria(categoria,id),HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> borrarCategoriaById(@PathVariable UUID id){
        try{
            categoriaService.borrarCategoriaById(id);
            return new ResponseEntity<>("Categoria borrada correctamente",HttpStatus.OK);
        }catch (Exception ex){
            throw new BadRequestExcepcion("Error al borrar la categoria");
        }
    }

}
