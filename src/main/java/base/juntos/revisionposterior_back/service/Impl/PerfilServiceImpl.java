package base.juntos.revisionposterior_back.service.Impl;

import base.juntos.revisionposterior_back.dto.request.UsuInicioSessionRequest;
import base.juntos.revisionposterior_back.model.Perfiles;
import base.juntos.revisionposterior_back.repository.PerfilRepository;
import base.juntos.revisionposterior_back.service.PerfilService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilServiceImpl implements PerfilService {

    private final PerfilRepository repo;

    public PerfilServiceImpl(PerfilRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Perfiles> listarPerfiles(UsuInicioSessionRequest parametros) {
        return repo.listarPerfiles(parametros);
    }
}
