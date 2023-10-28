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
import proyecto1.frontend.service.PageCategoriaService;

import java.util.List;
@Controller
@Slf4j
public class ControllerFrontEndCategoria {
    @Autowired
    private PageCategoriaService pageCategoriaService;

    @GetMapping("/categorias")
    public String categoriaIndex(Model model) {
        log.info("Obteniendo categorias ");
        List<Categoria> categorias = pageCategoriaService.getAllCategoria();
        model.addAttribute("categorias",categorias);
        return "Categoria";
    }
    @GetMapping("/agregar-categoria")
    public String addCategoria(Categoria categoria) {
        log.info("obteniendo pagina principal");
        return "Agregarcategorias";
    }
    @PostMapping("/page/categoria/guardar")
    public String showPageCategoria(Categoria categoria) {
        log.info("agregando Categoria" + categoria);
        pageCategoriaService.agregarCategoria(categoria);
        return "redirect:/categorias";
    }
    @GetMapping("/editar-categoria/{idCategoria}")
    public String modifyCategoria(Categoria categoria, Model model, @PathVariable("idCategoria") Long categoriaId) {
        log.info("obteniendo editar categorias");
        log.info(String.valueOf(categoria));
        log.info("categoriaId: "+ categoriaId);
        categoria = pageCategoriaService.findById(categoriaId);
        model.addAttribute("categoria",categoria);
        return "EditarCategorias";
    }
    @PostMapping("/page/categoria/editar")
    public String showModifyPageCategoria(Categoria categoria) {
        log.info("editando categoria" + categoria);
        pageCategoriaService.editarCategoria(categoria);
        return "redirect:http://localhost:8080/categorias";
    }
    @GetMapping("/page/categoria/eliminar/{id}")
    public String showDeletePageCategoria(@PathVariable("id") Long categoriaId) {
        log.info("eliminando categoria" + categoriaId);
        pageCategoriaService.eliminarCategoria(categoriaId);
        return "redirect:http://localhost:8080/categorias";
    }

}
