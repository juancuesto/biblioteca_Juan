package biblioteca_postgreSQL.biblioteca_Juan.service;

import biblioteca_postgreSQL.biblioteca_Juan.entity.Categoria;
import biblioteca_postgreSQL.biblioteca_Juan.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    /**
     * Guarda una nueva categoria en base de datos
     * @param categoria categoria a guardar
     * @return categoria guardada
     */
    public Categoria saveCategoria(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    /**
     * obtenemos una categoria por su Id
     * @param id el Id de la categoria buscada
     * @return categoria encontrada, si no la encuentra devuelve null
     */
    public Categoria getCategoriaById(UUID id){
        return categoriaRepository.findById(id).orElse(null);
    }

    /**
     * obtenes todas las categorias
     * @return lista de categorias
     */
    public List<Categoria> getAllCategorias(){
        return categoriaRepository.findAll();
    }

    /**
     * Borrar categoria por Id
     * @param id el id de la categoria a borrar
     */
    public void deleteCategoriaById(UUID id){
        categoriaRepository.deleteById(id);
    }
}
