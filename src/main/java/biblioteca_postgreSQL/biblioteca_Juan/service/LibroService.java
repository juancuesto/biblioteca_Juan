package biblioteca_postgreSQL.biblioteca_Juan.service;

import biblioteca_postgreSQL.biblioteca_Juan.entity.Libro;
import biblioteca_postgreSQL.biblioteca_Juan.error.BadRequestExcepcion;
import biblioteca_postgreSQL.biblioteca_Juan.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;

    /**
     * Guarda un libro nuevo en base de datos
     * @param libro libro a guardar
     * @return libro guardado
     */
    public Libro saveLibro(Libro libro){
        return libroRepository.save(libro);
    }

    /**
     * obtenemos un libro por su ID
     * @param id el id del libro buscado
     * @return el libro buscado, sino lo encuentra devuelve null
     */
    public Libro getLibroById(UUID id){
        if(id==null){
            throw new BadRequestExcepcion("Debes introducir un ID");
        } else if (!(id instanceof UUID)) {
            throw new BadRequestExcepcion("El formato del ID introducido no es correcto");
        }else {
            return libroRepository.findById(id).orElse(null);
        }
    }

    /**
     * obtenemos todos los libros en base de datos
     * @return lista de libros
     */
    public List<Libro> getAllLibros(){
        return libroRepository.findAll();
    }

    /**
     * borrar libro de base de datos por su ID
     * @param id el ID del libro a borrar
     */
    public void deleteLibroById(UUID id){
        libroRepository.deleteById(id);
    }
}
