package biblioteca_postgreSQL.biblioteca_Juan.repository;

import biblioteca_postgreSQL.biblioteca_Juan.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, UUID> {
}
