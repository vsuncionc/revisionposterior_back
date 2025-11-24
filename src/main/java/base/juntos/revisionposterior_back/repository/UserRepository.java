package base.juntos.revisionposterior_back.repository;

import base.juntos.revisionposterior_back.dto.request.UsuInicioSessionRequest;
import base.juntos.revisionposterior_back.model.UserEntity;

import java.util.Optional;

public interface UserRepository {
  Optional<UserEntity> inicioSession(String username);
}
