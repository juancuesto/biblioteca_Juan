package biblioteca_postgreSQL.biblioteca_Juan.service;

import biblioteca_postgreSQL.biblioteca_Juan.entity.Autor;
import biblioteca_postgreSQL.biblioteca_Juan.entity.Usuario;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UsuarioService {
    Usuario crearUsuario(Usuario usuario);
    Usuario actualizarUsuario(Usuario usuario, UUID id);
    Optional<Usuario> buscarUsuarioById(UUID id);
    List<Usuario> listarUsuarios();
    void  borrarUsuarioById(UUID id);
}
