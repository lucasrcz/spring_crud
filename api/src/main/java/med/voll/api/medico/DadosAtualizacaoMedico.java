package med.voll.api.medico;

import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import med.voll.api.endereco.CadastroEndereco;
@Getter
@Setter
@EqualsAndHashCode
public class DadosAtualizacaoMedico{
    @NotNull
    private Long id;
    private String nome;
    private String telefone;
    private String email;
    private CadastroEndereco endereco;

    public DadosAtualizacaoMedico(@NotNull Long id, String nome, String telefone, String email, CadastroEndereco endereco) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }
}
