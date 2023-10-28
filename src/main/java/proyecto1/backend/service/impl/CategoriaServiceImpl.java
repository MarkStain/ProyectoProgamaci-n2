package proyecto1.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import proyecto1.backend.dao.CategoriaDao;
import proyecto1.backend.model.Categoria;

import java.util.List;
@Service
public class CategoriaServiceImpl implements CategoriaService {
    @Autowired
    private CategoriaDao categoriaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Categoria> findAll() {
        return (List<Categoria>) categoriaDao.findAll();

    }

    @Override
    @Transactional
    public Categoria create(Categoria categoria) {
        return categoriaDao.save(categoria);
    }

    @Override
    @Transactional
    public boolean delete(Long categoriaId) {
        categoriaDao.deleteById(categoriaId);
        return true;
    }

    @Transactional
    @Override
    public Categoria modify(Long categoriaId, Categoria categoriaNuevo) {
        Categoria categoriaActual = categoriaDao.findById(categoriaId).stream().findFirst().orElse(null);
        if (categoriaActual != null) {
            categoriaActual.setNombre(categoriaNuevo.getNombre());
        }
        return categoriaActual;

    }

    @Override
    public Categoria findById(Long id) {
        return categoriaDao.findById(id).stream().findFirst().orElse(null);
    }
}
