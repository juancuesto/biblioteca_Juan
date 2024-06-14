package biblioteca_postgreSQL.biblioteca_Juan.service;

import biblioteca_postgreSQL.biblioteca_Juan.entity.Autor;
import biblioteca_postgreSQL.biblioteca_Juan.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AutorService {
    @Autowired
    private AutorRepository autorRepository;

    /**
     * Guarda un nuevo autor en base de datos
     * @param autor el autor a guardar
     * @return el autor guardado
     */
    public Autor saveAutor(Autor autor){
        return autorRepository.save(autor);
    }

    /**
     * obtenemos un autor por su ID
     * @param id el ID del autor buscado
     * @return el autor encontrado, o null sino lo encuentra
     */
    public Autor getAutorById(UUID id){
        return autorRepository.findById(id).orElse(null);
    }

    /**
     * obtiene todos los autores
     * @return lista de autores
     */
    public List<Autor> getAllAutores(){
        return autorRepository.findAll();
    }

    /**
     * borramos autor por su ID
     * @param id el ID del autor a eliminar
     */
    public void deleteAutorById(UUID id){
        autorRepository.deleteById(id);
    }
}
