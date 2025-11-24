package base.juntos.revisionposterior_back.repository.Impl;


import base.juntos.revisionposterior_back.model.UserEntity;
import base.juntos.revisionposterior_back.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final EntityManager em;
    private static final String ESQUEMA = "SEGURIDAD.PKG_SEGURIDAD";

    public UserRepositoryImpl(EntityManager em) {
        this.em = em;
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<UserEntity> inicioSession(String username) {
        var sp = em
                .createStoredProcedureQuery(ESQUEMA+".PINFOUSUARIO", UserEntity.class)
                .registerStoredProcedureParameter("P_OUT_CURSOR",void.class, ParameterMode.REF_CURSOR)
                .registerStoredProcedureParameter("P_IN_USUARIO",String.class, ParameterMode.IN)
                .setParameter("P_IN_USUARIO",username);
        sp.execute();
        return sp.getResultList().stream().findFirst();
    }
}
