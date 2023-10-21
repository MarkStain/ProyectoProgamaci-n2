package proyecto1.backend.dto;

import lombok.Data;
import proyecto1.backend.model.Editorial;

import java.io.Serializable;
import java.util.List;

@Data
public class EditorialList implements Serializable {

    private List<Editorial> editoriales;
}
