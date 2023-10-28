package proyecto1.backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "autor")
public class Autor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAutor", nullable = false)
    private Integer id;

    @Column(name = "Nombre", nullable = false, length = 45)
    private String nombre;

    @Column(name = "Apellido", nullable = false, length = 45)
    private String apellido;

    @Column(name = "FechaDeNacimiento", nullable = false)
    private LocalDate fechaDeNacimiento;

    public Autor(Integer id) {
        this.id = id;
    }
    public Autor() {

    }
}