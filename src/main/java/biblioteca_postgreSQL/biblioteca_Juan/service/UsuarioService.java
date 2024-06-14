package biblioteca_postgreSQL.biblioteca_Juan.service;

import biblioteca_postgreSQL.biblioteca_Juan.entity.Usuario;
import biblioteca_postgreSQL.biblioteca_Juan.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * Guarda un usuario nuevo en base de datos
     * @param usuario
     * @return
     */
    public Usuario saveUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    /**
     * obtenemos un usuario por su ID
     * @param id el id del usuario a buscar
     * @return el usuario encontrado o null sino lo encuentra
     */
    public Usuario getUsuarioById(UUID id){
        return usuarioRepository.findById(id).orElse(null);
    }

    /**
     * obtenemos todos los usuarios
     * @return listado de ususarios
     */
    public List<Usuario> getAllUsuarios(){
        return usuarioRepository.findAll();
    }

    /**
     * borrar usrario por id
     * @param id el id del usuario a borrar
     */
    public void deleteUsuarioById(UUID id){
        usuarioRepository.deleteById(id);
    }
}
