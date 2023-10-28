package proyecto1.frontend.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import proyecto1.backend.model.Autor;

import proyecto1.frontend.service.PageAutorService;


import java.util.List;
@Controller
@Slf4j
public class ControllerFrontEndAutores {
    @Autowired
    private PageAutorService pageAutorService;


    @GetMapping("/autores")
    public String autorIndex(Model model) {
        log.info("Obteniendo autores ");
        List<Autor> autores = pageAutorService.getAllAutor();
        model.addAttribute("autores",autores);
        return "Autor";
    }
    @GetMapping("/agregar-autor")
    public String addAutor(Autor autor) {
        log.info("obteniendo pagina principal");
        return "AgregarAutores";
    }
    @PostMapping("/page/autor/guardar")
    public String showPageAutor(Autor autor) {
        log.info("agregando Autor" + autor);
        pageAutorService.agregarAutor(autor);
        return "redirect:/autores";
    }
    @GetMapping("/editar-autor/{idAutor}")
    public String modifyAutor(Autor autor, Model model, @PathVariable("idAutor") Long autorId) {
        log.info("obteniendo editar autores");
        log.info(String.valueOf(autor));
        log.info("autorId: "+ autorId);
        autor = pageAutorService.findById(autorId);
        model.addAttribute("autor",autor);
        return "EditarAutores";
    }
    @PostMapping("/page/autor/editar")
    public String showModifyPageAutor(Autor autor) {
        log.info("editando autor" + autor);
        pageAutorService.editarAutor(autor);
        return "redirect:http://localhost:8080/autores";
    }
    @GetMapping("/page/autor/eliminar/{id}")
    public String showDeletePageAutor(@PathVariable("id") Long autorId) {
        log.info("eliminando autor" + autorId);
        pageAutorService.eliminarAutor(autorId);
        return "redirect:http://localhost:8080/autores";
    }
}
