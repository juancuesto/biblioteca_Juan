package biblioteca_postgreSQL.biblioteca_Juan.controller;

import biblioteca_postgreSQL.biblioteca_Juan.entity.Usuario;
import biblioteca_postgreSQL.biblioteca_Juan.error.BadRequestExcepcion;
import biblioteca_postgreSQL.biblioteca_Juan.service.LibroServiceImpl;
import biblioteca_postgreSQL.biblioteca_Juan.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/add")
    public ResponseEntity<?> crearUsuario(@RequestBody Usuario usuario){
        return new ResponseEntity<>(usuarioService.crearUsuario(usuario), HttpStatus.CREATED);
    }
    @GetMapping("/getOne/{id}")
    public ResponseEntity<?> buscarUsuarioById(@PathVariable UUID id){
        return new ResponseEntity<>(usuarioService.buscarUsuarioById(id),HttpStatus.FOUND);
    }
    @GetMapping("/listar")
    public ResponseEntity<?> listarUsuarios(){
        return new ResponseEntity<>(usuarioService.listarUsuarios(),HttpStatus.FOUND);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> actualizarUsuario(@RequestBody Usuario usuario,@PathVariable UUID id){
        return new ResponseEntity<>(usuarioService.actualizarUsuario(usuario,id),HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> borrarUsuarioById(@PathVariable UUID id){
        try{
            usuarioService.borrarUsuarioById(id);
            return new ResponseEntity<>("Usuario borrado correctamente",HttpStatus.OK);
        }catch (Exception ex){
            throw new BadRequestExcepcion("Error al borrar el Usuario");
        }
    }
}
