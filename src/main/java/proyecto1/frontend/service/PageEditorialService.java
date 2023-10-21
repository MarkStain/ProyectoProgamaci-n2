package proyecto1.frontend.service;

import proyecto1.backend.model.Editorial;

import java.util.List;

public interface PageEditorialService {
    public List<Editorial> getAllEditorial();

    public void agregarEditorial(Editorial editorial);

    public void editarEditorial(Editorial editorial);

    public Editorial findById(Long id);

    public void eliminarEditorial(Long editorialId);
}
