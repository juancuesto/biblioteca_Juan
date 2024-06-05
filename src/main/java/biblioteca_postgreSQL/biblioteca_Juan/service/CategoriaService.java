package biblioteca_postgreSQL.biblioteca_Juan.service;

import biblioteca_postgreSQL.biblioteca_Juan.entity.Autor;
import biblioteca_postgreSQL.biblioteca_Juan.entity.Categoria;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoriaService {
    Categoria crearCategoria(Categoria categoria);
    Categoria actualizarCategoria(Categoria categoria, UUID id);
    Optional<Categoria> buscarCategoriaById(UUID id);
    List<Categoria> listarCategorias();
    void  borrarCategoriaById(UUID id);
}
