package base.juntos.revisionposterior_back.repository.Impl;

import base.juntos.revisionposterior_back.dto.request.UsuInicioSessionRequest;
import base.juntos.revisionposterior_back.model.Perfiles;
import base.juntos.revisionposterior_back.repository.PerfilRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PerfilRepositoryImpl implements PerfilRepository {
    private final EntityManager em;
    private static final String ESQUEMA = "SEGURIDAD.PKG_SEGURIDAD";

    public PerfilRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Perfiles> listarPerfiles(UsuInicioSessionRequest parametros) {
        var sp = em
                .createStoredProcedureQuery(ESQUEMA+".PLISTAPERFILES", Perfiles.class)
                .registerStoredProcedureParameter("P_OUT_CURSOR",void.class, ParameterMode.REF_CURSOR)
                .registerStoredProcedureParameter("P_IN_COD_USUARIO",String.class, ParameterMode.IN)
                .setParameter("P_IN_COD_USUARIO",parametros.getCodUsuario());
        sp.execute();
        return sp.getResultList();
    }
}
