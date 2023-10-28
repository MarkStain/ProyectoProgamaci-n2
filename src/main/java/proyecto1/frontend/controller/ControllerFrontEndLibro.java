package proyecto1.frontend.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import proyecto1.backend.model.Categoria;
import proyecto1.backend.model.Libro;
import proyecto1.backend.service.impl.CategoriaService;
import proyecto1.backend.service.impl.LibroService;
import proyecto1.frontend.service.PageAutorService;
import proyecto1.frontend.service.PageCategoriaService;
import proyecto1.frontend.service.PageEditorialService;
import proyecto1.frontend.service.PageLibroService;

import java.util.ArrayList;
import java.util.List;
@Controller
@Slf4j
public class ControllerFrontEndLibro {
    @Autowired
    private PageLibroService pageLibroService;
    @Autowired
    private PageEditorialService pageEditorialService;
    @Autowired
    private PageCategoriaService pageCategoriaService;
    @Autowired
    private PageAutorService pageAutorService;


    @GetMapping("/libros")
    public String libroIndex(Model model) {
        log.info("Obteniendo libros ");
        List<Libro> libros = pageLibroService.getAllLibro();
        model.addAttribute("libros",libros);
        return "Libro";
    }
    @GetMapping("/agregar-libro")
    public String addLibro(Libro libro, Model model) {
        log.info("obteniendo pagina principal");
        model.addAttribute("comboBoxCategoria",pageCategoriaService.getAllCategoria());
        model.addAttribute("comboBoxEditorial",pageEditorialService.getAllEditorial());
        model.addAttribute("comboBoxAutor",pageAutorService.getAllAutor());

        return "Agregarlibros";
    }
    @PostMapping("/page/libro/guardar")
    public String showPageLibro(Libro libro) {
        log.info("agregando Libro" + libro);
        log.info(String.valueOf(libro.getIdAutor().getId()));
        libro.setAutor(libro.getIdAutor().getId());
        libro.setEditorial(libro.getIdEditorial().getId());
        libro.setCategoria(libro.getIdCategoria().getId());
        pageLibroService.agregarLibro(libro);
        return "redirect:/libros";
    }
    @GetMapping("/editar-libro/{idLibro}")
    public String modifyLibro(Libro libro, Model model, @PathVariable("idLibro") Long libroId) {
        log.info("obteniendo editar libros");
        log.info(String.valueOf(libro));
        log.info("libroId: "+ libroId);
        model.addAttribute("comboBoxCategoria",pageCategoriaService.getAllCategoria());
        model.addAttribute("comboBoxEditorial",pageEditorialService.getAllEditorial());
        model.addAttribute("comboBoxAutor",pageAutorService.getAllAutor());
        libro = pageLibroService.findById(libroId);
        model.addAttribute("libro",libro);
        return "EditarLibros";
    }
    @PostMapping("/page/libro/editar")
    public String showModifyPageLibro(Libro libro) {
        log.info("editando libro" + libro);
        pageLibroService.editarLibro(libro);
        return "redirect:http://localhost:8080/libros";
    }
    @GetMapping("/page/libro/eliminar/{id}")
    public String showDeletePageLibro(@PathVariable("id") Long libroId) {
        log.info("eliminando libro" + libroId);
        pageLibroService.eliminarLibro(libroId);
        return "redirect:http://localhost:8080/libros";
    }

}
