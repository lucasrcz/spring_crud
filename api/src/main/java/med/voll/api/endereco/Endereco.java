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
@EqualsAndHashCode
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

    public void AtualizarInformacoes(CadastroEndereco endereco) {
        if(endereco.getLogradouro() != null){
            this.logradouro = endereco.getLogradouro();
        }
        if(endereco.bairro != null){
            this.bairro = endereco.getBairro();
        }
        if(endereco.getCep() != null){
            this.cep = endereco.getCep();
        }
        if(endereco.getNumero() != null){
            this.numero = endereco.getNumero();
        }
        if(endereco.getComplemento() != null){
            this.complemento = endereco.getComplemento();
        }
        if(endereco.getCidade() != null){
            this.cidade = endereco.getCidade();
        }
        if(endereco.getUf() != null){
            this.uf = endereco.getUf();
        }

    }
}
