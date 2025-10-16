package base.juntos.revisionposterior_back.service;

import base.juntos.revisionposterior_back.dto.request.UsuInicioSessionRequest;
import base.juntos.revisionposterior_back.model.Usuario;

import java.util.Optional;

public interface UsuarioService {
    Optional<Usuario> inicioSession(UsuInicioSessionRequest parametro);
}
