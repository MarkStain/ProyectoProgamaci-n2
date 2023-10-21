package proyecto1.frontend.service;

import proyecto1.backend.model.Autor;

import java.util.List;

public interface PageAutorService {
    public List<Autor> getAllAutor();

    public void agregarAutor(Autor autor);

    public void editarAutor(Autor autor);

    public Autor findById(Long id);

    public void eliminarAutor(Long AutorId);
}
