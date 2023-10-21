package proyecto1.frontend.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
import proyecto1.backend.dto.EditorialList;
import proyecto1.backend.model.Editorial;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class PageEditorialServiceImpl implements PageEditorialService {


    @Override
    public List<Editorial> getAllEditorial() {
        RestTemplate restTemplate = new RestTemplate();

        Editorial[] editoriales = restTemplate.getForObject("http://localhost:8080/editorial", Editorial[].class);
        List<Editorial> editorialList = null;
        if (editoriales != null) {
            editorialList = Arrays.asList(editoriales);
        }
        System.out.println(editorialList);
        return editorialList;
    }

    @Override
    public void agregarEditorial(Editorial editorial) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject("http://localhost:8080/editorial", editorial, Editorial.class);
    }

    @Override
    public void editarEditorial(Editorial editorial) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put("http://localhost:8080/editorial/" + editorial.getId(), editorial, Editorial.class);
    }

    @Override
    public Editorial findById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:8080/editorial/" + id, Editorial.class);
    }
    @Override
    public void eliminarEditorial(@PathVariable("idEditorial") Long editorialId) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete("http://localhost:8080/editorial/" + editorialId, null, Editorial.class);
    }
}
