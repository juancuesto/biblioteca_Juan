package biblioteca_postgreSQL.biblioteca_Juan.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;
@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_usuario;

    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;

    @OneToMany(mappedBy = "usuario")
    private List<Prestamo> prestamos; // Lista de préstamos asociados con este usuario
}
