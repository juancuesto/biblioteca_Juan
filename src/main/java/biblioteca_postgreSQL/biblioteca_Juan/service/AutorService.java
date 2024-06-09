package biblioteca_postgreSQL.biblioteca_Juan.service;

import biblioteca_postgreSQL.biblioteca_Juan.entity.Autor;
import biblioteca_postgreSQL.biblioteca_Juan.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Servicio para la entidad Autor.
 */
@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    /**
     * Guarda un nuevo autor en la base de datos.
     *
     * @param autor El autor a guardar.
     * @return El autor guardado.
     */
    public Autor saveAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    /**
     * Obtiene un autor por su ID.
     *
     * @param id El ID del autor.
     * @return El autor encontrado, o null si no se encuentra.
     */
    public Autor getAutorById(UUID id) {
        return autorRepository.findById(id).orElse(null);
    }

    /**
     * Obtiene todos los autores.
     *
     * @return Lista de autores.
     */
    public List<Autor> getAllAutores() {
        return autorRepository.findAll();
    }
   
    /**
     * Elimina un autor por su ID.
     *
     * @param id El ID del autor a eliminar.
     */
    public void deleteAutor(UUID id) {
        autorRepository.deleteById(id);
    }
}