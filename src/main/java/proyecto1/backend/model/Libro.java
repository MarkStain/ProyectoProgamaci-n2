package proyecto1.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;
import org.springframework.data.annotation.Transient;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@ToString
@Table(name = "libro")
public class Libro implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLibro", nullable = false)
    private Integer id;

    @Column(name = "Nombre", nullable = false, length = 45)
    private String nombre;

    @Column(name = "`AñoDeEdicion`", nullable = false)
    private LocalDate anoDeEdicion;


    @Column(name = "Paginas", nullable = false)
    private Integer paginas;

    @Column(name = "Idioma", nullable = false, length = 45)
    private String idioma;


    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idEditorial", nullable = false)
    private Editorial idEditorial;

    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idAutor", nullable = false)
    private Autor idAutor;

    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idCategoria", nullable = false)
    private Categoria idCategoria;
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Transient
    private int categoria;
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Transient
    private int autor;
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Transient
    private int editorial;

}