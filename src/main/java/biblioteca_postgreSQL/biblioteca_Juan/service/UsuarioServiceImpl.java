package biblioteca_postgreSQL.biblioteca_Juan.service;

import biblioteca_postgreSQL.biblioteca_Juan.entity.Prestamo;
import biblioteca_postgreSQL.biblioteca_Juan.entity.Usuario;
import biblioteca_postgreSQL.biblioteca_Juan.error.BadRequestExcepcion;
import biblioteca_postgreSQL.biblioteca_Juan.error.ResourceNotFoundException;
import biblioteca_postgreSQL.biblioteca_Juan.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuario, UUID id) {
        Optional<Usuario> usuarioOptional=usuarioRepository.findById(id);
        if (usuarioOptional.isEmpty()){
            throw new ResourceNotFoundException("Usuario","id",id);
        } else if (id==null) {
            throw new BadRequestExcepcion("El id tiene un formato incorrecto o no existe");
        }
       usuarioOptional.get().setNombre(usuario.getNombre());
        usuarioOptional.get().setApellido(usuario.getApellido());
        usuarioOptional.get().setDireccion(usuario.getDireccion());
        usuarioOptional.get().setTelefono(usuario.getTelefono());
        return usuarioRepository.save(usuarioOptional.get());
    }

    @Override
    public Optional<Usuario> buscarUsuarioById(UUID id) {
        Optional<Usuario> usuarioOptional=usuarioRepository.findById(id);
        if (usuarioOptional.isEmpty()){
            throw new ResourceNotFoundException("Usuario","id",id);
        } else if (id==null) {
            throw new BadRequestExcepcion("El id tiene un formato incorrecto o no existe");
        }
        return usuarioOptional;
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public void borrarUsuarioById(UUID id) {
        Optional<Usuario> usuarioOptional=usuarioRepository.findById(id);
        if (usuarioOptional.isEmpty()){
            throw new ResourceNotFoundException("Usuario","id",id);
        } else if (id==null) {
            throw new BadRequestExcepcion("El id tiene un formato incorrecto o no existe");
        }
        usuarioRepository.deleteById(id);
    }
}
