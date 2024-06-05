package biblioteca_postgreSQL.biblioteca_Juan.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "autores")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id_autor;
    private String nombre;
    private String apellido;
    private String nacionalidad;
    private Date fecha_nacimiento;
}
