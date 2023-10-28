package proyecto1.backend.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto1.backend.dao.EditorialDao;
import proyecto1.backend.dao.LibroDao;
import proyecto1.backend.dto.Mensaje;
import proyecto1.backend.model.Editorial;
import proyecto1.backend.model.Libro;
import proyecto1.backend.service.EditorialService;
import proyecto1.backend.service.impl.LibroService;

import java.util.List;

@RestController
@RequestMapping(value = "/libro")
@Slf4j
public class LibroWeb {
    @Autowired
    private LibroDao libroDao;
    @Autowired
    private LibroService libroService;

    @GetMapping
    public List<Libro> findAllRequest() {

        return libroService.findAll();
    }

    @PostMapping
    public Libro createRequest(@RequestBody Libro libro) {
        log.info(String.valueOf(libro));
        log.info(String.valueOf(libro.getCategoria()));
        log.info(String.valueOf(libro.getAutor()));
        log.info(String.valueOf(libro.getEditorial()));

        return libroService.create(libro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRequest(@PathVariable("id") Long libroId) {
        log.info(String.valueOf(libroId));
        libroService.delete(libroId);
        return ResponseEntity.ok(new Mensaje("exito"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modifyRequest(@PathVariable("id") Long libroId, @RequestBody Libro libro) {
        log.info(String.valueOf(libroId));
        log.info(String.valueOf(libro));
        if (libro == null) {
            return ResponseEntity.badRequest().build();
        }
        Libro libroResult = libroService.modify(libroId, libro);

        return ResponseEntity.ok(libroResult == null ? new Mensaje("No existe libro con el id: " + libroId) : libroResult);
    }

    @GetMapping("/{id}")
    public Libro findByIdRequest(@PathVariable("id") Long libroId) {
        return libroService.findById(libroId);
    }

}
