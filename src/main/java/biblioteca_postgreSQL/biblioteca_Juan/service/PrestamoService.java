package biblioteca_postgreSQL.biblioteca_Juan.service;

import biblioteca_postgreSQL.biblioteca_Juan.entity.Prestamo;
import biblioteca_postgreSQL.biblioteca_Juan.repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Servicio para la entidad Prestamo.
 */
@Service
public class PrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    /**
     * Guarda un nuevo préstamo en la base de datos.
     *
     * @param prestamo El préstamo a guardar.
     * @return El préstamo guardado.
     */
    public Prestamo savePrestamo(Prestamo prestamo) {
        return prestamoRepository.save(prestamo);
    }

    /**
     * Obtiene un préstamo por su ID.
     *
     * @param id El ID del préstamo.
     * @return El préstamo encontrado, o null si no se encuentra.
     */
    public Prestamo getPrestamoById(UUID id) {
        Optional<Prestamo> prestamo = prestamoRepository.findById(id);
        return prestamo.orElse(null);
    }

    /**
     * Obtiene todos los préstamos.
     *
     * @return Lista de préstamos.
     */
    public List<Prestamo> getAllPrestamos() {
        return prestamoRepository.findAll();
    }

    /**
     * Elimina un préstamo por su ID.
     *
     * @param id El ID del préstamo a eliminar.
     */
    public void deletePrestamo(UUID id) {
        prestamoRepository.deleteById(id);
    }

}
