package med.voll.api.paciente;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import med.voll.api.controller.Paciente;
@Getter
@Setter
@EqualsAndHashCode

public class DadosListagemPaciente {
    private String nome;
    private String email;
    private String telefone;

    public DadosListagemPaciente(Paciente dados){
        this.nome = dados.getNome();
        this.email = dados.getEmail();
        this.telefone = dados.getTelefone();

    }
}
