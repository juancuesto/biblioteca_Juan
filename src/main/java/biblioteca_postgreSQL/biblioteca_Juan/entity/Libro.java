package biblioteca_postgreSQL.biblioteca_Juan.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Entidad Libro que representa un libro en la base de datos.
 */
@Entity
@Table(name = "libros")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Libro {

    /**
     * Identificador único del libro.
     * Generado automáticamente usando la estrategia de identidad.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_libro;

    private String ISBN;
    private String titulo;
    private String autor;
    private Date any_publicacion;

    /**
     * Relación muchos a uno con la entidad Categoría.
     * Un libro pertenece a una sola categoría.
     */
    @ManyToOne
    @JoinColumn(name = "id_categoria") // Nombre de la columna que une con la tabla Categoría
    private Categoria categoria; // Referencia a la categoría del libro

    /**
     * Relación muchos a muchos con la entidad Autor.
     * Un libro puede tener múltiples autores.
     */
    @ManyToMany
    @JoinTable(
        name = "autor_libro", // Nombre de la tabla intermedia
        joinColumns = @JoinColumn(name = "id_libro"), // Columna que une con la tabla Libro
        inverseJoinColumns = @JoinColumn(name = "id_autor") // Columna que une con la tabla Autor
    )
    private List<Autor> autores; // Lista de autores asociados con este libro

    /**
     * Relación muchos a muchos con la entidad Prestamo.
     * Un libro puede estar en múltiples préstamos.
     */
    @ManyToMany(mappedBy = "librosPrestados")
    private List<Prestamo> prestamos; // Lista de préstamos asociados con este libro
}