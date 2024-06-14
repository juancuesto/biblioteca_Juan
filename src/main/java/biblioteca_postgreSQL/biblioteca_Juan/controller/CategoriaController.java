package biblioteca_postgreSQL.biblioteca_Juan.controller;

import biblioteca_postgreSQL.biblioteca_Juan.entity.Categoria;
import biblioteca_postgreSQL.biblioteca_Juan.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;
    @PostMapping
    public ResponseEntity<?> crearCategoria(@RequestBody Categoria categoria){
        return new ResponseEntity<>(categoriaService.saveCategoria(categoria), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public  ResponseEntity<?> getCategoriaById(@PathVariable UUID id){
        Categoria categoria=categoriaService.getCategoriaById(id);
        if (categoria!=null){
            return new ResponseEntity<>(categoria,HttpStatus.FOUND);
        }else {
            return new ResponseEntity<>("No se ha encontrado la categoria",HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping
    public ResponseEntity<?> getAllCategorias(){
        return new ResponseEntity<>(categoriaService.getAllCategorias(),HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarCategoria(@RequestBody Categoria categoria,@PathVariable UUID id){
        Categoria categoria1=categoriaService.getCategoriaById(id);
        if (categoria1!=null){
            categoria1.setId_categoria(categoria.getId_categoria());
            return new ResponseEntity<>(categoriaService.saveCategoria(categoria1),HttpStatus.OK);
        }else {
            return new ResponseEntity<>("No se ha encontrado la categoria a actualiazar",HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategoriaById(@PathVariable UUID id){
        Categoria categoria1=categoriaService.getCategoriaById(id);
        if (categoria1!=null){
            categoriaService.deleteCategoriaById(id);
            return new ResponseEntity<>("Categoria borrada correctamente",HttpStatus.OK);
        }else {
            return new ResponseEntity<>("No se ha encontrado la categoria a borrar",HttpStatus.NOT_FOUND);
        }
    }
}
