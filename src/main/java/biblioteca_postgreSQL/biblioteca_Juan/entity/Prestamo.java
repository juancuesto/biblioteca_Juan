package biblioteca_postgreSQL.biblioteca_Juan.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Entidad Prestamo que representa un préstamo de libros en la base de datos.
 */
@Entity
@Table(name = "prestamos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prestamo {

    /**
     * Identificador único del préstamo.
     * Generado automáticamente usando la estrategia de identidad.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_prestamo;

    private Date fecha_prestamo;
    private Date fecha_devolucion;

    /**
     * Relación muchos a muchos con la entidad Libro.
     * Esta relación se gestiona a través de una tabla intermedia prestamo_libro.
     */
    @ManyToMany
    @JoinTable(
        name = "prestamo_libro", // Nombre de la tabla intermedia
        joinColumns = @JoinColumn(name = "id_prestamo"), // Columna que une con la tabla Prestamo
        inverseJoinColumns = @JoinColumn(name = "id_libro") // Columna que une con la tabla Libro
    )
    private List<Libro> librosPrestados; // Lista de libros asociados con este préstamo

    /**
     * Relación muchos a uno con la entidad Usuario.
     * Un préstamo pertenece a un solo usuario.
     */
    @ManyToOne
    @JoinColumn(name = "id_usuario") // Nombre de la columna que une con la tabla Usuario
    private Usuario usuario; // Referencia al usuario que realiza el préstamo
}