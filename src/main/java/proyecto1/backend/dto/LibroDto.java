package proyecto1.backend.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import proyecto1.backend.model.Autor;
import proyecto1.backend.model.Categoria;
import proyecto1.backend.model.Editorial;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@ToString
public class LibroDto implements Serializable {

    private Integer id;

    private String nombre;

    private String anoDeEdicion;

    private Integer paginas;

    private String idioma;

    private int editorial;

    private int autor;

    private int categoria;
}
