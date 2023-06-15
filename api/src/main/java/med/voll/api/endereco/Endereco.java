package med.voll.api.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public Endereco(CadastroEndereco dados) {
        this.logradouro = dados.getLogradouro();
        this.bairro = dados.getBairro();
        this.cep= dados.getCep();
        this.uf = dados.getUf();
        this.cidade = dados.getCidade();
        this.numero = dados.getNumero();
        this.complemento = dados.getComplemento();

    }
}
