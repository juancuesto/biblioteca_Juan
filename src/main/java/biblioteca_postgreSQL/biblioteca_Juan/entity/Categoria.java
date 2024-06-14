package biblioteca_postgreSQL.biblioteca_Juan.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "categorias")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {

    /**
     * Identificador único de la categoría.
     * Generado automáticamente usando la estrategia de identidad.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_categoria;

    private String nombreCategoria;

    @OneToMany(mappedBy = "categoria")
    private List<Libro> libros; // Lista de libros asociados con esta categoría
}
