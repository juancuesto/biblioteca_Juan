package biblioteca_postgreSQL.biblioteca_Juan.service;

import biblioteca_postgreSQL.biblioteca_Juan.entity.Autor;
import biblioteca_postgreSQL.biblioteca_Juan.entity.Categoria;
import biblioteca_postgreSQL.biblioteca_Juan.error.BadRequestExcepcion;
import biblioteca_postgreSQL.biblioteca_Juan.error.ResourceNotFoundException;
import biblioteca_postgreSQL.biblioteca_Juan.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class CategoriaServiceImpl implements CategoriaService{
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Override
    public Categoria crearCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria actualizarCategoria(Categoria categoria, UUID id) {
        Optional<Categoria> categoriaOptional=categoriaRepository.findById(id);
        if (categoriaOptional.isEmpty()){
            throw new ResourceNotFoundException("Categoria","id",id);
        } else if (id==null) {
            throw new BadRequestExcepcion("El id tiene un formato incorrecto o no existe");
        }
        categoriaOptional.get().setNombreCategoria(categoria.getNombreCategoria());
        return categoriaRepository.save(categoriaOptional.get());
    }

    @Override
    public Optional<Categoria> buscarCategoriaById(UUID id) {
        Optional<Categoria> categoriaOptional=categoriaRepository.findById(id);
        if (categoriaOptional.isEmpty()){
            throw new ResourceNotFoundException("Categoria","id",id);
        } else if (id==null) {
            throw new BadRequestExcepcion("El id tiene un formato incorrecto o no existe");
        }
        return categoriaRepository.findById(id);
    }

    @Override
    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }

    @Override
    public void borrarCategoriaById(UUID id) {
        Optional<Categoria> categoriaOptional=categoriaRepository.findById(id);
        if (categoriaOptional.isEmpty()){
            throw new ResourceNotFoundException("Categoria","id",id);
        } else if (id==null) {
            throw new BadRequestExcepcion("El id tiene un formato incorrecto o no existe");
        }
        categoriaRepository.deleteById(id);
    }
}
