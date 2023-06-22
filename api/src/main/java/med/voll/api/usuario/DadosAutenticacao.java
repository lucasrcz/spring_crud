package med.voll.api.usuario;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DadosAutenticacao {
    private String login;
    private String senha;
}
