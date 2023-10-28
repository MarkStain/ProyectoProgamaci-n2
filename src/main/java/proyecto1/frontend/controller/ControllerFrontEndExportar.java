package proyecto1.frontend.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import proyecto1.backend.dto.LibroDto;
import proyecto1.frontend.service.PageDownloadService;

import java.util.List;

@Controller
@Slf4j
public class ControllerFrontEndExportar {
    @Autowired
    private PageDownloadService pageDownloadService;
    @GetMapping("/exportacion-de-datos")
    public String exportarIndex(Model model) {
        log.info("Obteniendo exportacion ");
        return "ExportarDatos";
    }
    @PostMapping("/download")
    public ResponseEntity<byte[]> downloadFile() throws JsonProcessingException {
        List<LibroDto> lista = pageDownloadService.downloadLibros();
        log.info("descargando");
        for (LibroDto libro: lista) {
            log.info(String.valueOf(libro));
        }
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        String customerJsonString = mapper.writeValueAsString(lista);
        byte[] customerJsonBytes = customerJsonString.getBytes();

        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=lista.json")
                .contentType(MediaType.APPLICATION_JSON)
                .contentLength(customerJsonBytes.length)
                .body(customerJsonBytes);
    }
}
