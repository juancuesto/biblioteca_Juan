package biblioteca_postgreSQL.biblioteca_Juan.service;

import biblioteca_postgreSQL.biblioteca_Juan.entity.Libro;
import biblioteca_postgreSQL.biblioteca_Juan.entity.Prestamo;
import biblioteca_postgreSQL.biblioteca_Juan.error.BadRequestExcepcion;
import biblioteca_postgreSQL.biblioteca_Juan.error.ResourceNotFoundException;
import biblioteca_postgreSQL.biblioteca_Juan.repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class PrestamoServiceImpl implements PrestamoService{
    @Autowired
    private PrestamoRepository prestamoRepository;
    @Override
    public Prestamo crearPrestamo(Prestamo prestamo) {
        return prestamoRepository.save(prestamo);
    }

    @Override
    public Prestamo actualizarPrestamo(Prestamo prestamo, UUID id) {
        Optional<Prestamo> prestamoOptional=prestamoRepository.findById(id);
        if (prestamoOptional.isEmpty()){
            throw new ResourceNotFoundException("Prestamo","id",id);
        } else if (id==null) {
            throw new BadRequestExcepcion("El id tiene un formato incorrecto o no existe");
        }
        prestamoOptional.get().setFecha_prestamo(prestamo.getFecha_prestamo());
        prestamoOptional.get().setFecha_devolucion(prestamo.getFecha_devolucion());
        prestamoOptional.get().setId_usuario(prestamo.getId_usuario());
        prestamoOptional.get().setLibrosPrestados(prestamo.getLibrosPrestados());
        return prestamoRepository.save(prestamoOptional.get());
    }

    @Override
    public Optional<Prestamo> buscarPrestamoById(UUID id) {
        Optional<Prestamo> prestamoOptional=prestamoRepository.findById(id);
        if (prestamoOptional.isEmpty()){
            throw new ResourceNotFoundException("Prestamo","id",id);
        } else if (id==null) {
            throw new BadRequestExcepcion("El id tiene un formato incorrecto o no existe");
        }
        return prestamoOptional;
    }

    @Override
    public List<Prestamo> listarPrestamos() {
        return prestamoRepository.findAll();
    }

    @Override
    public void borrarPrestamoById(UUID id) {
        Optional<Prestamo> prestamoOptional=prestamoRepository.findById(id);
        if (prestamoOptional.isEmpty()){
            throw new ResourceNotFoundException("Prestamo","id",id);
        } else if (id==null) {
            throw new BadRequestExcepcion("El id tiene un formato incorrecto o no existe");
        }
        prestamoRepository.deleteById(id);
    }
}
