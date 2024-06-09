package biblioteca_postgreSQL.biblioteca_Juan.service;

import biblioteca_postgreSQL.biblioteca_Juan.entity.Categoria;
import biblioteca_postgreSQL.biblioteca_Juan.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Servicio para la entidad Categoría.
 */
@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    /**
     * Guarda una nueva categoría en la base de datos.
     *
     * @param categoria La categoría a guardar.
     * @return La categoría guardada.
     */
    public Categoria saveCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    /**
     * Obtiene una categoría por su ID.
     *
     * @param id El ID de la categoría.
     * @return La categoría encontrada, o null si no se encuentra.
     */
    public Categoria getCategoriaById(UUID id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    /**
     * Obtiene todas las categorías.
     *
     * @return Lista de categorías.
     */
    public List<Categoria> getAllCategorias() {
        return categoriaRepository.findAll();
    }

    /**
     * Elimina una categoría por su ID.
     *
     * @param id El ID de la categoría a eliminar.
     */
    public void deleteCategoria(UUID id) {
        categoriaRepository.deleteById(id);
    }
}