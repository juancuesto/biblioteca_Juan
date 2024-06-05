package biblioteca_postgreSQL.biblioteca_Juan.service;

import biblioteca_postgreSQL.biblioteca_Juan.entity.Autor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AutorService {
    Autor crearAutor(Autor autor);
    Autor actualizarAutor(Autor autor, UUID id);
    Optional<Autor> buscarAutorById(UUID id);
    List<Autor> listarAutores();
    void  borrarAutorById(UUID id);
}
