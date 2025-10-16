package base.juntos.revisionposterior_back.repository.Impl;

import base.juntos.revisionposterior_back.dto.request.UsuInicioSessionRequest;
import base.juntos.revisionposterior_back.model.Usuario;
import base.juntos.revisionposterior_back.repository.UsuarioRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {

    private final EntityManager em;
    private static final String ESQUEMA = "SEGURIDAD.PKG_SEGURIDAD";

    public UsuarioRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Optional<Usuario> inicioSession(UsuInicioSessionRequest parametro) {
        var sp = em
              .createStoredProcedureQuery(ESQUEMA+".PINFOUSUARIO",Usuario.class)
              .registerStoredProcedureParameter("P_OUT_CURSOR",void.class,ParameterMode.REF_CURSOR)
              .registerStoredProcedureParameter("P_IN_USUARIO",String.class, ParameterMode.IN)
              .setParameter("P_IN_USUARIO",parametro.getUsuario());
            sp.execute();
          return sp.getResultList().stream().findFirst();
    }
}
