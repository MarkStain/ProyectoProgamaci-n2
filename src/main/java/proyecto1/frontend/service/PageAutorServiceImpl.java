package proyecto1.frontend.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
import proyecto1.backend.model.Autor;
import proyecto1.backend.model.Editorial;

import java.util.Arrays;
import java.util.List;
@Service
public class PageAutorServiceImpl implements PageAutorService{
    @Override
    public List<Autor> getAllAutor() {
        RestTemplate restTemplate = new RestTemplate();

        Autor[] autores = restTemplate.getForObject("http://localhost:8080/autor", Autor[].class);
        List<Autor> autorList = null;
        if (autores != null) {
            autorList = Arrays.asList(autores);
        }
        System.out.println(autorList);
        return autorList;
    }

    @Override
    public void agregarAutor(Autor autor) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject("http://localhost:8080/autor", autor, Autor.class);
    }

    @Override
    public void editarAutor(Autor autor) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put("http://localhost:8080/autor/" + autor.getId(), autor, Autor.class);
    }

    @Override
    public Autor findById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:8080/autor/" + id, Autor.class);
    }
    @Override
    public void eliminarAutor(@PathVariable("idAutor") Long autorId) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete("http://localhost:8080/autor/" + autorId, null, Autor.class);
    }
}
