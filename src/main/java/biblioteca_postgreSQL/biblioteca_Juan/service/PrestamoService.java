package biblioteca_postgreSQL.biblioteca_Juan.service;

import biblioteca_postgreSQL.biblioteca_Juan.entity.Prestamo;
import biblioteca_postgreSQL.biblioteca_Juan.repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PrestamoService {
    @Autowired
    private PrestamoRepository prestamoRepository;

    /**
     * Guardar un prestamo nuevo en base de datos
     * @param prestamo el prestamo a guardar
     * @return el prestamo guardado
     */
    public Prestamo savePrestamo(Prestamo prestamo){
        return prestamoRepository.save(prestamo);
    }

    /**
     * obtenemos un prestamo por su ID
     * @param id el id del prestamo buscado
     * @return el prestamo encontrado o null sino lo encuentra
     */
    public Prestamo getPrestamoById(UUID id){
        return prestamoRepository.findById(id).orElse(null);
    }

    /**
     * obtenemos todos los prestamos de la bade de datos
     * @return listado de prestamos
     */
    public List<Prestamo> getAllPrestamos(){
        return prestamoRepository.findAll();
    }

    /**
     * borrar un prestamo por su id
     * @param id el id del prestamo a borrar
     */
    public void deletePrestamoById(UUID id){
        prestamoRepository.deleteById(id);
    }
}
