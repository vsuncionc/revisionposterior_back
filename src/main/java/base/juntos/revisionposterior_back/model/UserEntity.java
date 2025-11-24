package base.juntos.revisionposterior_back.model;


import io.vavr.collection.Set;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserEntity {

    @Id
    @Column(name = "COD_USUARIO")
    private String id;

    @Column(name = "USUARIO")
    private String username;

    @Column(name = "DES_PASSWORD")
    private String password;

    @Column(name = "cuenta_habilitada")
    private boolean enabled;

    @Column(name = "cuenta_expirada")
    private boolean accountNonExpired;

    @Column(name = "cuenta_bloqueada")
    private boolean accountNonLocked;

    @Column(name = "credencial_expirada")
    private boolean credentialsNonExpired;

    private transient List<Perfiles> listaPerfiles;



}
