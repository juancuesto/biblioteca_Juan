package biblioteca_postgreSQL.biblioteca_Juan.service;

import biblioteca_postgreSQL.biblioteca_Juan.entity.Categoria;
import biblioteca_postgreSQL.biblioteca_Juan.entity.Libro;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LibroService {
    Libro crearLibro(Libro libro);
    Libro actualizarLibro(Libro libro, UUID id);
    Optional<Libro> buscarLibroById(UUID id);
    List<Libro> listarLibros();
    void  borrarLibroById(UUID id);
}
