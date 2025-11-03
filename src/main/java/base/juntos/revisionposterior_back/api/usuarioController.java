package base.juntos.revisionposterior_back.api;

import base.juntos.revisionposterior_back.dto.request.UsuInicioSessionRequest;
import base.juntos.revisionposterior_back.model.Usuario;
import base.juntos.revisionposterior_back.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class usuarioController {
    private final UsuarioService service;

    public usuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping(value = "/inicio")
    public ResponseEntity<Usuario> buscarPorId(@Valid @RequestBody UsuInicioSessionRequest parametro) {
        return service.inicioSession(parametro)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
