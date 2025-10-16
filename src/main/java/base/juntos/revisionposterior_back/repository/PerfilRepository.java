package base.juntos.revisionposterior_back.repository;

import base.juntos.revisionposterior_back.dto.request.UsuInicioSessionRequest;
import base.juntos.revisionposterior_back.model.Perfiles;

import java.util.List;

public interface PerfilRepository {
    List<Perfiles> listarPerfiles(UsuInicioSessionRequest parametros);
}
