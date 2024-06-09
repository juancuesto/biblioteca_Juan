package biblioteca_postgreSQL.biblioteca_Juan.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Entidad Autor que representa un autor en la base de datos.
 */
@Entity
@Table(name = "autores")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Autor {

    /**
     * Identificador único del autor.
     * Generado automáticamente usando la estrategia de identidad.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_autor;

    private String nombre;
    private String apellido;
    private String nacionalidad;
    private Date fecha_nacimiento;

    /**
     * Relación muchos a muchos con la entidad Libro.
     * Esta relación se gestiona a través de una tabla intermedia autor_libro.
     */
    @ManyToMany
    @JoinTable(
        name = "autor_libro", // Nombre de la tabla intermedia
        joinColumns = @JoinColumn(name = "id_autor"), // Columna que une con la tabla Autor
        inverseJoinColumns = @JoinColumn(name = "id_libro") // Columna que une con la tabla Libro
    )
    private List<Libro> libros; // Lista de libros asociados con este autor
}