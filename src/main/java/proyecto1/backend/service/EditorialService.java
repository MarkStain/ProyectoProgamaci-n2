package proyecto1.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import proyecto1.backend.dao.EditorialDao;
import proyecto1.backend.model.Editorial;

import java.util.List;


public interface EditorialService {
    public List<Editorial> findAll();
    public Editorial create(Editorial editorial);
    public boolean delete(Long editorialId);
    public Editorial modify(Long editorialId, Editorial editorialNuevo);

    public Editorial findById(Long id);
}
