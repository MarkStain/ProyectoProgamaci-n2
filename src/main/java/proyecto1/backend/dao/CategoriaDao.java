package proyecto1.backend.dao;

import org.springframework.data.repository.CrudRepository;
import proyecto1.backend.model.Categoria;

public interface CategoriaDao extends CrudRepository<Categoria,Long> {
}
