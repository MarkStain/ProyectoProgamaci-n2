package proyecto1.backend.service.impl;

import proyecto1.backend.model.Autor;
import proyecto1.backend.model.Editorial;

import java.util.List;

public interface AutorService {
    public List<Autor> findAll();

    public Autor create(Autor autor);

    public boolean delete(Long autorId);

    public Autor modify(Long autorId, Autor autorNuevo);

    public Autor findById(Long id);
}
