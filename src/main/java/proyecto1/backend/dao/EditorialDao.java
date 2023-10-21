package proyecto1.backend.dao;

import org.springframework.data.repository.CrudRepository;
import proyecto1.backend.model.Editorial;

public interface EditorialDao extends CrudRepository<Editorial,Long> {
}
