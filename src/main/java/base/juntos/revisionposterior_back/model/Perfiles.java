package base.juntos.revisionposterior_back.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Perfiles {
    @Id
    @Column(name = "COD_PERFIL")
    private String codigoPerfil;

    @Column(name = "DES_PERFIL")
    private String descripcion;
}
