package proyecto1.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import proyecto1.backend.dao.LibroDao;
import proyecto1.backend.model.Autor;
import proyecto1.backend.model.Categoria;
import proyecto1.backend.model.Editorial;
import proyecto1.backend.model.Libro;

import java.util.List;
@Service
public class LibroServiceImpl implements LibroService{
    @Autowired
    private LibroDao libroDao;
    @Override
    @Transactional(readOnly = true)
    public List<Libro> findAll(){
        return (List<Libro>) libroDao.findAll();

    }
    @Override
    @Transactional
    public Libro create(Libro libro){
        libro.setIdEditorial(new Editorial(libro.getEditorial()));
        libro.setIdAutor(new Autor(libro.getAutor()));
        libro.setIdCategoria(new Categoria(libro.getCategoria()));
        return libroDao.save(libro);
    }
    @Transactional
    @Override
    public boolean delete(Long libroId) {
        libroDao.deleteById(libroId);
        return true;
    }
    @Transactional
    @Override
    public Libro modify(Long libroId, Libro libroNuevo) {
        Libro libroActual = libroDao.findById(libroId).stream().findFirst().orElse(null);
        if (libroActual != null){
            libroActual.setNombre(libroNuevo.getNombre());
            libroActual.setAnoDeEdicion(libroNuevo.getAnoDeEdicion());
            libroActual.setEditorial(libroNuevo.getEditorial());
            libroActual.setAutor(libroNuevo.getAutor());
            libroActual.setPaginas(libroNuevo.getPaginas());
            libroActual.setIdioma(libroNuevo.getIdioma());
            libroActual.setCategoria(libroNuevo.getCategoria());
            libroActual=create(libroActual);
        }
        return libroActual;

    }

    @Override
    public Libro findById(Long id) {
        return libroDao.findById(id).stream().findFirst().orElse(null);
    }
}
