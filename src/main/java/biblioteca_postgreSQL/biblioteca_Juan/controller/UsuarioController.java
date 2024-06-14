package biblioteca_postgreSQL.biblioteca_Juan.controller;

import biblioteca_postgreSQL.biblioteca_Juan.entity.Prestamo;
import biblioteca_postgreSQL.biblioteca_Juan.entity.Usuario;
import biblioteca_postgreSQL.biblioteca_Juan.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;


    @PostMapping
    public ResponseEntity<?> crearUsuario(@RequestBody Usuario usuario) {
        return new ResponseEntity<>(usuarioService.saveUsuario(usuario), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUsuarioById(@PathVariable UUID id) {
        Usuario usuario=usuarioService.getUsuarioById(id);
        if (usuario != null) {
            return new ResponseEntity<>(usuario, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>("No se ha encontrado el Usuario", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllUsuario() {
        return new ResponseEntity<>(usuarioService.getAllUsuarios(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarUsuario(@RequestBody Usuario usuario, @PathVariable UUID id) {
        Usuario usuario1 = usuarioService.getUsuarioById(id);
        if (usuario1 != null) {
            usuario1.setId_usuario(usuario.getId_usuario());
            return new ResponseEntity<>(usuarioService.saveUsuario(usuario), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No se ha encontrado el Usuario a actualiazar", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUsuarioById(@PathVariable UUID id) {
        Usuario usuario=usuarioService.getUsuarioById(id);
        if (usuario != null) {
            usuarioService.deleteUsuarioById(id);
            return new ResponseEntity<>("Usuario borrado correctamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No se ha encontrado el Usuario a borrar", HttpStatus.NOT_FOUND);
        }
    }
}


