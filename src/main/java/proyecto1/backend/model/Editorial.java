package proyecto1.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
@Entity
@Table(name = "editorial")
public class Editorial implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEditorial", nullable = false)
    private Integer id;

    @Column(name = "Nombre", nullable = false, length = 250)
    private String nombre;

    @Column(name = "Ubicacion", nullable = false, length = 250)
    private String ubicacion;

    @Column(name = "Direccion", nullable = false, length = 250)
    private String direccion;
    public Editorial(Integer id) {
        this.id = id;
    }
    public Editorial() {

    }
}