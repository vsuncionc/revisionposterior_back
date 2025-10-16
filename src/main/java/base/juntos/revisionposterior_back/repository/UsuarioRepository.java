package base.juntos.revisionposterior_back.repository;

import base.juntos.revisionposterior_back.dto.request.UsuInicioSessionRequest;
import base.juntos.revisionposterior_back.model.Usuario;

import java.util.Optional;

public interface UsuarioRepository {
  Optional<Usuario> inicioSession(UsuInicioSessionRequest parametro);
}
