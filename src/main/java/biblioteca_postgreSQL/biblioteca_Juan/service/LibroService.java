package biblioteca_postgreSQL.biblioteca_Juan.service;

import biblioteca_postgreSQL.biblioteca_Juan.entity.Libro;
import biblioteca_postgreSQL.biblioteca_Juan.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Servicio para la entidad Libro.
 */
@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    /**
     * Guarda un nuevo libro en la base de datos.
     *
     * @param libro El libro a guardar.
     * @return El libro guardado.
     */
    public Libro saveLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    /**
     * Obtiene un libro por su ID.
     *
     * @param id El ID del libro.
     * @return El libro encontrado, o null si no se encuentra.
     */
    public Libro getLibroById(UUID id) {
        return libroRepository.findById(id).orElse(null);
    }

    /**
     * Obtiene todos los libros.
     *
     * @return Lista de libros.
     */
    public List<Libro> getAllLibros() {
        return libroRepository.findAll();
    }

    /**
     * Elimina un libro por su ID.
     *
     * @param id El ID del libro a eliminar.
     */
    public void deleteLibro(UUID id) {
        libroRepository.deleteById(id);
    }
}