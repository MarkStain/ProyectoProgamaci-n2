package proyecto1.frontend.service;

import proyecto1.backend.model.Autor;
import proyecto1.backend.model.Categoria;

import java.util.List;

public interface PageCategoriaService {

    public List<Categoria> getAllCategoria();

    public void agregarCategoria(Categoria categoria);

    public void editarCategoria(Categoria categoria);

    public Categoria findById(Long id);

    public void eliminarCategoria(Long CategoriaId);
}
