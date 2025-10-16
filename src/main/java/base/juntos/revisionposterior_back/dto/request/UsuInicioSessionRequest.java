package base.juntos.revisionposterior_back.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuInicioSessionRequest {
    private String codUsuario;
    private  String usuario;
    private String clave;
}
