package biblioteca_postgreSQL.biblioteca_Juan.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.metamodel.mapping.SqlTypedMapping;
import org.hibernate.type.SqlTypes;

import java.sql.SQLType;
import java.util.UUID;
@Entity
@Table(name = "libros")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id_libro;
    private String ISBN;
    private String titulo;
    private String autor;
    private int any_publicacion;
    @JdbcTypeCode(SqlTypes.JSON)
    private Categoria categoria;
}
