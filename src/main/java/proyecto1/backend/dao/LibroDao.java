package proyecto1.backend.dao;

import org.springframework.data.repository.CrudRepository;
import proyecto1.backend.model.Editorial;
import proyecto1.backend.model.Libro;

public interface LibroDao extends CrudRepository<Libro,Long> {
}
