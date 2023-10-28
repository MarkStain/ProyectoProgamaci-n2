package proyecto1.frontend.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
import proyecto1.backend.model.Editorial;
import proyecto1.backend.model.Libro;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class PageLibroServiceImpl implements PageLibroService {


    @Override
    public List<Libro> getAllLibro() {
        RestTemplate restTemplate = new RestTemplate();

        log.info("Obteniendo libros service");
        Libro[] libros = restTemplate.getForObject("http://localhost:8080/libro", Libro[].class);
        List<Libro> libroList = null;
        if (libros != null) {
            libroList = Arrays.asList(libros);
        }
        return libroList;
    }

    @Override
    public void agregarLibro(Libro libro) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject("http://localhost:8080/libro", libro, Libro.class);
    }

    @Override
    public void editarLibro(Libro libro) {
        libro.setEditorial(libro.getIdEditorial().getId());
        libro.setAutor(libro.getIdAutor().getId());
        libro.setCategoria(libro.getIdCategoria().getId());
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put("http://localhost:8080/libro/" + libro.getId(), libro, Libro.class);
    }

    @Override
    public Libro findById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:8080/libro/" + id, Libro.class);
    }

    @Override
    public void eliminarLibro(@PathVariable("idLibro") Long editorialId) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete("http://localhost:8080/libro/" + editorialId, null, Libro.class);
    }
}
