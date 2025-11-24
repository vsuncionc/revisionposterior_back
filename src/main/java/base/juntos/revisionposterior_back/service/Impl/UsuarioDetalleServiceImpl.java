package base.juntos.revisionposterior_back.service.Impl;

import base.juntos.revisionposterior_back.model.Perfiles;
import base.juntos.revisionposterior_back.model.UserEntity;
import base.juntos.revisionposterior_back.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioDetalleServiceImpl implements UserDetailsService {
    private final UserRepository repo;
    private final PerfilServiceImpl servPerfil;

    public UsuarioDetalleServiceImpl(UserRepository repo, PerfilServiceImpl servPerfil) {
        this.repo = repo;
        this.servPerfil = servPerfil;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity info = repo.inicioSession(username)
                .orElseThrow(()->new UsernameNotFoundException("El usuario "+ username+" no existe"));

        System.out.println(info.getUsername()+"--"+info.getId());

        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();

        //BUSCAMOS LOS ROLES
       // List<Perfiles> lista = servPerfil.listarPerfiles2(info.getId());

        info.setListaPerfiles(servPerfil.listarPerfiles2(info.getId()));
        info.getListaPerfiles()
                .forEach(role->authorityList.add(new SimpleGrantedAuthority("ROLE_".concat(role.getCodigoPerfil()))));

        /*List<SimpleGrantedAuthority> listaAurorizacion =
                lista.stream()
                        .map(p -> new SimpleGrantedAuthority("ROLE_".concat(p.getCodigoPerfil())))
                        .toList();*/

      return new User(info.getUsername(),
                info.getPassword(),
                info.isEnabled(),
                info.isAccountNonExpired(),
                info.isCredentialsNonExpired(),
                info.isAccountNonLocked(),
                authorityList
        );
        /*return  new User(
                "MHUAYRA",
                "123",
                true,
                true,
                true,
                true,
                authorityList
        );*/

    }
}
