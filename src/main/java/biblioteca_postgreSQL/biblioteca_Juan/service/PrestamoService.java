package biblioteca_postgreSQL.biblioteca_Juan.service;

import biblioteca_postgreSQL.biblioteca_Juan.entity.Libro;
import biblioteca_postgreSQL.biblioteca_Juan.entity.Prestamo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PrestamoService {

    Prestamo crearPrestamo(Prestamo prestamo);
    Prestamo actualizarPrestamo(Prestamo prestamo, UUID id);
    Optional<Prestamo> buscarPrestamoById(UUID id);
    List<Prestamo> listarPrestamos();
    void  borrarPrestamoById(UUID id);
}
