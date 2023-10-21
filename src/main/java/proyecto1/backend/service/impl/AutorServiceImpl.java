package proyecto1.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import proyecto1.backend.dao.AutorDao;
import proyecto1.backend.model.Autor;

import java.util.List;
@Service
public class AutorServiceImpl implements AutorService {
    @Autowired
    private AutorDao autorDao;

    @Override
    @Transactional(readOnly = true)
    public List<Autor> findAll() {
        return (List<Autor>) autorDao.findAll();

    }

    @Override
    @Transactional
    public Autor create(Autor autor) {
        return autorDao.save(autor);
    }

    @Override
    @Transactional
    public boolean delete(Long autorId) {
        autorDao.deleteById(autorId);
        return true;
    }

    @Transactional
    @Override
    public Autor modify(Long autorId, Autor autorNuevo) {
        Autor autorActual = autorDao.findById(autorId).stream().findFirst().orElse(null);
        if (autorActual != null) {
            autorActual.setNombre(autorNuevo.getNombre());
            autorActual.setApellido(autorNuevo.getApellido());
            autorActual.setFechaDeNacimiento(autorNuevo.getFechaDeNacimiento());
        }
        return autorActual;

    }

    @Override
    public Autor findById(Long id) {
        return autorDao.findById(id).stream().findFirst().orElse(null);
    }
}
