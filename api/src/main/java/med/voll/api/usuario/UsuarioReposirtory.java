package med.voll.api.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import med.voll.api.controller.Usuario;

public interface UsuarioReposirtory extends JpaRepository<Usuario , Long> {

    UserDetails findByLogin(String login);
    
}
