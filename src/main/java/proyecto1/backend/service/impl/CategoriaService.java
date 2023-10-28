package proyecto1.backend.service.impl;

import proyecto1.backend.model.Autor;
import proyecto1.backend.model.Categoria;

import java.util.List;

public interface CategoriaService {
    public List<Categoria> findAll();

    public Categoria create(Categoria categoria);

    public boolean delete(Long categoriaId);

    public Categoria modify(Long categoriaId, Categoria categoriaNuevo);

    public Categoria findById(Long id);
}
