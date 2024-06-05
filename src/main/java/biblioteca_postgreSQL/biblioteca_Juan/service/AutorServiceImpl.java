package biblioteca_postgreSQL.biblioteca_Juan.service;

import biblioteca_postgreSQL.biblioteca_Juan.entity.Autor;
import biblioteca_postgreSQL.biblioteca_Juan.error.BadRequestExcepcion;
import biblioteca_postgreSQL.biblioteca_Juan.error.ResourceNotFoundException;
import biblioteca_postgreSQL.biblioteca_Juan.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class AutorServiceImpl implements AutorService{
    @Autowired
    private AutorRepository autorRepository;
    @Override
    public Autor crearAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    @Override
    public Autor actualizarAutor(Autor autor, UUID id) {
        Optional<Autor> autorOptional=autorRepository.findById(id);
        if (autorOptional.isEmpty()){
            throw new ResourceNotFoundException("Autor","id",id);
        } else if (id==null) {
            throw new BadRequestExcepcion("El id tiene un formato incorrecto o no existe");
        }
        autorOptional.get().setNombre(autor.getNombre());
        autorOptional.get().setApellido(autor.getApellido());
        autorOptional.get().setNacionalidad(autor.getNacionalidad());
        autorOptional.get().setFecha_nacimiento(autor.getFecha_nacimiento());
        return autorRepository.save(autorOptional.get());
    }

    @Override
    public Optional<Autor> buscarAutorById(UUID id) {
        Optional<Autor> autorOptional = autorRepository.findById(id);
        if (autorOptional.isEmpty()) {
            throw new ResourceNotFoundException("Autor", "id", id);
        } else if (id == null) {
            throw new BadRequestExcepcion("El id tiene un formato incorrecto o no existe");
        }
        return autorOptional;
    }

    @Override
    public List<Autor> listarAutores() {
        return autorRepository.findAll();
    }

    @Override
    public void borrarAutorById(UUID id) {
        Optional<Autor> autorOptional = autorRepository.findById(id);
        if (autorOptional.isEmpty()) {
            throw new ResourceNotFoundException("Autor", "id", id);
        } else if (id == null) {
            throw new BadRequestExcepcion("El id tiene un formato incorrecto o no existe");
        }
        autorRepository.deleteById(id);
    }
}
