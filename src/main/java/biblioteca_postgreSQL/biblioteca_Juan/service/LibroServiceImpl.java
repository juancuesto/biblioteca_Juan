package biblioteca_postgreSQL.biblioteca_Juan.service;

import biblioteca_postgreSQL.biblioteca_Juan.entity.Categoria;
import biblioteca_postgreSQL.biblioteca_Juan.entity.Libro;
import biblioteca_postgreSQL.biblioteca_Juan.entity.Usuario;
import biblioteca_postgreSQL.biblioteca_Juan.error.BadRequestExcepcion;
import biblioteca_postgreSQL.biblioteca_Juan.error.ResourceNotFoundException;
import biblioteca_postgreSQL.biblioteca_Juan.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class LibroServiceImpl implements LibroService{
    @Autowired
    private LibroRepository libroRepository;
    @Override
    public Libro crearLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    @Override
    public Libro actualizarLibro(Libro libro, UUID id) {
        Optional<Libro> libroOptional=libroRepository.findById(id);
        if (libroOptional.isEmpty()){
            throw new ResourceNotFoundException("Libro","id",id);
        } else if (id==null) {
            throw new BadRequestExcepcion("El id tiene un formato incorrecto o no existe");
        }
        libroOptional.get().setISBN(libro.getISBN());
        libroOptional.get().setAutor(libro.getAutor());
        libroOptional.get().setTitulo(libro.getTitulo());
        //libroOptional.get().setCategoria(libro.getCategoria());
        libroOptional.get().setAny_publicacion(libro.getAny_publicacion());
        return libroRepository.save(libroOptional.get());
    }

    @Override
    public Optional<Libro> buscarLibroById(UUID id) {
        Optional<Libro> libroOptional=libroRepository.findById(id);
        if (libroOptional.isEmpty()){
            throw new ResourceNotFoundException("Categoria","id",id);
        } else if (id==null) {
            throw new BadRequestExcepcion("El id tiene un formato incorrecto o no existe");
        }
        return libroRepository.findById(id);
    }

    @Override
    public List<Libro> listarLibros() {
        return libroRepository.findAll();
    }

    @Override
    public void borrarLibroById(UUID id) {
        Optional<Libro> libroOptional=libroRepository.findById(id);
        if (libroOptional.isEmpty()){
            throw new ResourceNotFoundException("Categoria","id",id);
        } else if (id==null) {
            throw new BadRequestExcepcion("El id tiene un formato incorrecto o no existe");
        }
        libroRepository.deleteById(id);
    }
}
