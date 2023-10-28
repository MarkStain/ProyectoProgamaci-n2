package proyecto1.frontend.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import proyecto1.backend.dto.LibroDto;
import proyecto1.backend.model.Libro;

import java.io.File;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class PageDownloadServiceImpl implements PageDownloadService {
    @Autowired
    private PageLibroService pageLibroService;

    @Override
    public List<LibroDto> downloadLibros() {
        log.info("hola");

        List<Libro> libroList = pageLibroService.getAllLibro();
        List<LibroDto> libroDtoList = new ArrayList<>();
        for (Libro libro : libroList) {
            LibroDto libroDto = new LibroDto();
            libroDto.setId(libro.getId());
            libroDto.setAutor(libro.getAutor());
            libroDto.setCategoria(libro.getCategoria());
            libroDto.setEditorial(libro.getEditorial());
            libroDto.setIdioma(libro.getIdioma());
            libroDto.setPaginas(libro.getPaginas());
            libroDto.setNombre(libro.getNombre());
            libroDto.setAnoDeEdicion(String.valueOf(libro.getAnoDeEdicion()));
            log.info(String.valueOf(libroDto));
            libroDtoList.add(libroDto);
        }
        return libroDtoList;
    }
}
