package proyecto1.backend.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto1.backend.dao.AutorDao;
import proyecto1.backend.dao.EditorialDao;
import proyecto1.backend.dto.Mensaje;
import proyecto1.backend.model.Autor;
import proyecto1.backend.model.Editorial;
import proyecto1.backend.service.EditorialService;
import proyecto1.backend.service.impl.AutorService;

import java.util.List;

@RestController
@RequestMapping(value = "/autor")
@Slf4j
public class AutorWeb {
    @Autowired
    private AutorDao autorDao;
    @Autowired
    private AutorService autorService;

    @GetMapping
    public List<Autor> findAllRequest() {
        return autorService.findAll();
    }

    @PostMapping
    public Autor createRequest(@RequestBody Autor autor) {
        log.info(String.valueOf(autor));
        return autorService.create(autor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRequest(@PathVariable("id") Long autorId) {
        log.info(String.valueOf(autorId));
        autorService.delete(autorId);
        return ResponseEntity.ok(new Mensaje("exito"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modifyRequest(@PathVariable("id") Long autorId, @RequestBody Autor autor) {
        log.info(String.valueOf(autorId));
        log.info(String.valueOf(autor));
        if (autor == null) {
            return ResponseEntity.badRequest().build();
        }
        Autor autorResult = autorService.modify(autorId, autor);

        return ResponseEntity.ok(autorResult == null ? new Mensaje("No existe autor con el id: " + autorId)  : autorResult);
    }
    @GetMapping("/{id}")
    public Autor findByIdRequest(@PathVariable("id") Long autorId) {
        return autorService.findById(autorId);
    }
}
