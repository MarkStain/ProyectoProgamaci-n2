package proyecto1.frontend.service;

import proyecto1.backend.model.Libro;

import java.util.List;

public interface PageLibroService {
    public List<Libro> getAllLibro();

    public void agregarLibro(Libro libro);

    public void editarLibro(Libro libro);

    public Libro findById(Long id);

    public void eliminarLibro(Long libroId);
}
