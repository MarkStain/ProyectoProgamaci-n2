package proyecto1.backend.dto;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Mensaje {
    @NonNull
    private String mensaje;
}
