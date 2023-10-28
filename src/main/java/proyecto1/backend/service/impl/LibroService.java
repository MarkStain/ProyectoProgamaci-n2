package proyecto1.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import proyecto1.backend.dao.EditorialDao;
import proyecto1.backend.dao.LibroDao;
import proyecto1.backend.model.Autor;
import proyecto1.backend.model.Editorial;
import proyecto1.backend.model.Libro;

import java.util.List;

public interface LibroService {
    public List<Libro> findAll();

    public Libro create(Libro libro);

    public boolean delete(Long libroId);

    public Libro modify(Long libroId, Libro libroNuevo);

    public Libro findById(Long id);
}

