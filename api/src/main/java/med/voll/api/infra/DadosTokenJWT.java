package med.voll.api.infra;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DadosTokenJWT {

    private String token;
    public DadosTokenJWT(String tokenJWT) {
        this.token = tokenJWT;
    }
}
