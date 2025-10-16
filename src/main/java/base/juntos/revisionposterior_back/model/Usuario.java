package base.juntos.revisionposterior_back.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Usuario {

   @Id
   @Column(name = "COD_USUARIO")
   private String id;

   @Column(name = "USUARIO")
   private String username;

   @Column(name = "DES_PASSWORD")
   private String password;

  private transient List<Perfiles> listaPerfiles;

}
