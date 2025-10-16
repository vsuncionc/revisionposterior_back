package base.juntos.revisionposterior_back.service.Impl;

import base.juntos.revisionposterior_back.dto.request.UsuInicioSessionRequest;
import base.juntos.revisionposterior_back.model.Usuario;
import base.juntos.revisionposterior_back.repository.UsuarioRepository;
import base.juntos.revisionposterior_back.service.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repo;
    private final PerfilServiceImpl servPerfil;

    public UsuarioServiceImpl(UsuarioRepository repo, PerfilServiceImpl servPerfil) {
        this.repo = repo;
        this.servPerfil = servPerfil;
    }

    @Override
    public Optional<Usuario> inicioSession(UsuInicioSessionRequest parametro) {
        Optional<Usuario> info = repo.inicioSession(parametro);
         if(!info.isEmpty()){
             parametro.setCodUsuario(info.get().getId());
           info.get().setListaPerfiles(servPerfil.listarPerfiles(parametro));
         }
        return info;
    }
}
