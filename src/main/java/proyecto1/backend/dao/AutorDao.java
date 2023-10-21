package proyecto1.backend.dao;

import org.springframework.data.repository.CrudRepository;
import proyecto1.backend.model.Autor;

public interface AutorDao extends CrudRepository<Autor,Long> {
}
