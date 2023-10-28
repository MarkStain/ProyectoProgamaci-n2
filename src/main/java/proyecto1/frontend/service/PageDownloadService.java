package proyecto1.frontend.service;

import proyecto1.backend.dto.LibroDto;

import java.util.List;

public interface PageDownloadService {
    public List<LibroDto> downloadLibros();
}
