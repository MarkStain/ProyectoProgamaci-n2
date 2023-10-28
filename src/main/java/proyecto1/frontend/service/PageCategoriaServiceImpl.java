package proyecto1.frontend.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
import proyecto1.backend.model.Categoria;

import java.util.Arrays;
import java.util.List;
@Service
public class PageCategoriaServiceImpl implements PageCategoriaService {
    @Override
    public List<Categoria> getAllCategoria() {
        RestTemplate restTemplate = new RestTemplate();

        Categoria[] categorias = restTemplate.getForObject("http://localhost:8080/categoria", Categoria[].class);
        List<Categoria> categoriaList = null;
        if (categorias != null) {
            categoriaList = Arrays.asList(categorias);
        }
        System.out.println(categoriaList);
        return categoriaList;
    }

    @Override
    public void agregarCategoria(Categoria categoria) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject("http://localhost:8080/categoria", categoria, Categoria.class);
    }

    @Override
    public void editarCategoria(Categoria categoria) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put("http://localhost:8080/categoria/" + categoria.getId(), categoria, Categoria.class);
    }

    @Override
    public Categoria findById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:8080/categoria/" + id, Categoria.class);
    }

    @Override
    public void eliminarCategoria(@PathVariable("idCategoria") Long categoriaId) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete("http://localhost:8080/categoria/" + categoriaId, null, Categoria.class);
    }
}
