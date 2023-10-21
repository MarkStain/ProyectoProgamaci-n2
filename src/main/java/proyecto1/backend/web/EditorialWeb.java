package proyecto1.backend.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import proyecto1.backend.dao.EditorialDao;
import proyecto1.backend.dto.Mensaje;
import proyecto1.backend.model.Editorial;
import proyecto1.backend.service.EditorialService;

import java.util.List;

@RestController
@RequestMapping(value = "/editorial")
@Slf4j
public class EditorialWeb {
    @Autowired
    private EditorialDao editorialDao;
    @Autowired
    private EditorialService editorialService;

    @GetMapping
    public List<Editorial> findAllRequest() {

        return editorialService.findAll();
    }

    @PostMapping
    public Editorial createRequest(@RequestBody Editorial editorial) {
        log.info(String.valueOf(editorial));
        return editorialService.create(editorial);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRequest(@PathVariable("id") Long editorialId) {
        log.info(String.valueOf(editorialId));
        editorialService.delete(editorialId);
        return ResponseEntity.ok(new Mensaje("exito"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modifyRequest(@PathVariable("id") Long editorialId, @RequestBody Editorial editorial) {
        log.info(String.valueOf(editorialId));
        log.info(String.valueOf(editorial));
        if (editorial == null) {
            return ResponseEntity.badRequest().build();
        }
        Editorial editorialResult = editorialService.modify(editorialId, editorial);

        return ResponseEntity.ok(editorialResult == null ? new Mensaje("No existe editorial con el id: " + editorialId) : editorialResult);
    }
    @GetMapping("/{id}")
    public Editorial findByIdRequest(@PathVariable("id") Long editorialId) {
        return editorialService.findById(editorialId);
    }

}
