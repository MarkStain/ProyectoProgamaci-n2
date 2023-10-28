package proyecto1.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import proyecto1.backend.dao.EditorialDao;
import proyecto1.backend.model.Editorial;
import proyecto1.backend.service.EditorialService;

import java.util.List;

@Service
public class EditorialServiceImpl implements EditorialService {
    @Autowired
    private EditorialDao editorialDao;
    @Override
    @Transactional(readOnly = true)
    public List<Editorial> findAll(){
        return (List<Editorial>) editorialDao.findAll();

    }
    @Override
    @Transactional
    public Editorial create(Editorial editorial){
        return editorialDao.save(editorial);
    }
    @Transactional
    @Override
    public boolean delete(Long editorialId) {
        editorialDao.deleteById(editorialId);
        return true;
    }
    @Transactional
    @Override
    public Editorial modify(Long editorialId, Editorial editorialNuevo) {
        Editorial editorialActual = editorialDao.findById(editorialId).stream().findFirst().orElse(null);
        if (editorialActual != null){
            editorialActual.setNombre(editorialNuevo.getNombre());
        }
        return editorialActual;

    }

    @Override
    public Editorial findById(Long id) {
        return editorialDao.findById(id).stream().findFirst().orElse(null);
    }
}
