package proyecto1.frontend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import proyecto1.backend.model.Libro;
import proyecto1.frontend.service.PageCargaService;
import proyecto1.frontend.service.PageLibroService;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.List;

@Controller
@Slf4j
public class ControllerFrontEndCarga {
    @Autowired
    private PageLibroService pageLibroService;
    @Autowired
    private PageCargaService pageCargaService;
    private final String UPLOAD_DIR = "./uploads/";

    @GetMapping("/carga-de-datos")
    public String cargaIndex(Model model) {
        log.info("Obteniendo carga ");
        return "CargaDeDatos";
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes attributes) {

        if (file.isEmpty()) {
            attributes.addFlashAttribute("message", "Por favor selecciona un archivo.");
            return "redirect:/";
        }

        pageCargaService.uploadData(file);
        attributes.addFlashAttribute("message", "Carga correctamente " + '!');
        return "redirect:/";
    }
}
