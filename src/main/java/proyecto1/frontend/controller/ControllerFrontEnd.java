package proyecto1.frontend.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import proyecto1.backend.model.Editorial;
import proyecto1.frontend.service.PageEditorialService;

import java.util.List;

@Controller
@Slf4j
public class ControllerFrontEnd {
    @Autowired
    private PageEditorialService pageEditorialService;
    @GetMapping("/")
    public String getIndex() {
        log.info("obteniendo pagina principal");
        return "index";
    }

    @GetMapping("/editoriales")
    public String editorialIndex(Model model) {
        log.info("Obteniendo editoriales ");
        List<Editorial> editoriales = pageEditorialService.getAllEditorial();
        model.addAttribute("editoriales",editoriales);
        return "Editorial";
    }
    @GetMapping("/agregar-editorial")
    public String addEditorial(Editorial editorial) {
        log.info("obteniendo pagina principal");
        return "AgregarEditoriales";
    }
    @PostMapping("/page/editorial/guardar")
    public String showPageEditorial(Editorial editorial) {
        log.info("agregando editorial" + editorial);
        pageEditorialService.agregarEditorial(editorial);
        return "redirect:/editoriales";
    }
    @GetMapping("/editar-editorial/{idEditorial}")
    public String modifyEditorial(Editorial editorial, Model model, @PathVariable("idEditorial") Long editorialId) {
        log.info("obteniendo editar editoriales");
        log.info(String.valueOf(editorial));
        log.info("editorialId: "+ editorialId);
        editorial = pageEditorialService.findById(editorialId);
        model.addAttribute("editorial",editorial);
        return "EditarEditoriales";
    }
    @PostMapping("/page/editorial/editar")
    public String showModifyPageEditorial(Editorial editorial) {
        log.info("editando editorial" + editorial);
        pageEditorialService.editarEditorial(editorial);
        return "redirect:http://localhost:8080/editoriales";
    }
    @GetMapping("/page/editorial/eliminar/{id}")
    public String showDeletePageEditorial(@PathVariable("id") Long editorialId) {
        log.info("eliminando editorial" + editorialId);
        pageEditorialService.eliminarEditorial(editorialId);
        return "redirect:http://localhost:8080/editoriales";
    }
}
