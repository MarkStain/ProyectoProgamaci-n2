package proyecto1.frontend.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import proyecto1.backend.model.Libro;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
@Service
@Slf4j
public class PageCargaServiceImpl implements PageCargaService {
    @Autowired
    private PageLibroService pageLibroService;


    @Override
    public void uploadData(MultipartFile file) {
        try {
            String text = new String(file.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
            log.info(text);
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            List<Libro> user2 = Arrays.asList(mapper.
                    readValue(text, Libro[].class));
            log.info("\nJSON array to List of objects");
            user2.stream().forEach(o -> {
                log.info(String.valueOf(o));
                pageLibroService.agregarLibro(o);
            });
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
