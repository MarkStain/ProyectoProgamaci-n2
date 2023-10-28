package proyecto1.backend.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto1.backend.dao.AutorDao;
import proyecto1.backend.dao.CategoriaDao;
import proyecto1.backend.dao.EditorialDao;
import proyecto1.backend.dto.Mensaje;
import proyecto1.backend.model.Autor;
import proyecto1.backend.model.Categoria;
import proyecto1.backend.model.Editorial;
import proyecto1.backend.service.EditorialService;
import proyecto1.backend.service.impl.AutorService;
import proyecto1.backend.service.impl.CategoriaService;

import java.util.List;

@RestController
@RequestMapping(value = "/categoria")
@Slf4j
public class CategoriaWeb {
    @Autowired
    private CategoriaDao categoriaDao;
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> findAllRequest() {
        return categoriaService.findAll();
    }

    @PostMapping
    public Categoria createRequest(@RequestBody Categoria categoria) {
        log.info(String.valueOf(categoria));
        return categoriaService.create(categoria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRequest(@PathVariable("id") Long categoriaId) {
        log.info(String.valueOf(categoriaId));
        categoriaService.delete(categoriaId);
        return ResponseEntity.ok(new Mensaje("exito"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modifyRequest(@PathVariable("id") Long categoriaId, @RequestBody Categoria categoria) {
        log.info(String.valueOf(categoriaId));
        log.info(String.valueOf(categoria));
        if (categoria == null) {
            return ResponseEntity.badRequest().build();
        }
        Categoria categoriaResult = categoriaService.modify(categoriaId, categoria);

        return ResponseEntity.ok(categoriaResult == null ? new Mensaje("No existe categoria con el id: " + categoriaId)  : categoriaResult);
    }
    @GetMapping("/{id}")
    public Categoria findByIdRequest(@PathVariable("id") Long categoriaId) {
        return categoriaService.findById(categoriaId);
    }
}
