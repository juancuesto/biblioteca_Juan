package biblioteca_postgreSQL.biblioteca_Juan.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.UUID;
@Entity
@Table(name = "prestamos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id_prestamo;
    private UUID id_usuario;
    private List<Libro> librosPrestados;
    private Date fecha_prestamo;
    private Date fecha_devolucion;
}
