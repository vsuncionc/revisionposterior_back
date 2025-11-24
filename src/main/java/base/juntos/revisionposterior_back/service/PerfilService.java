package base.juntos.revisionposterior_back.service;

import base.juntos.revisionposterior_back.dto.request.UsuInicioSessionRequest;
import base.juntos.revisionposterior_back.model.Perfiles;

import java.util.List;
import java.util.Set;

public interface PerfilService {
    List<Perfiles> listarPerfiles(UsuInicioSessionRequest parametros);
    List<Perfiles> listarPerfiles2(String codigoUsuario);
}
