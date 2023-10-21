package proyecto1.backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "libro")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLibro", nullable = false)
    private Integer id;

    @Column(name = "Nombre", nullable = false, length = 45)
    private String nombre;

    @Column(name = "`AñoDeEdicion`", nullable = false)
    private LocalDate añoDeEdicion;

    @Column(name = "Editorial", nullable = false, length = 45)
    private String editorial;

    @Column(name = "Autor", nullable = false, length = 45)
    private String autor;

    @Column(name = "Paginas", nullable = false)
    private Integer paginas;

    @Column(name = "Idioma", nullable = false, length = 45)
    private String idioma;

    @Column(name = "Categoria", nullable = false, length = 45)
    private String categoria;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idEditorial", nullable = false)
    private Editorial idEditorial;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idAutor", nullable = false)
    private Autor idAutor;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idCategoria", nullable = false)
    private Categoria idCategoria;

}