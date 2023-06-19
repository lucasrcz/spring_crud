package med.voll.api.medico;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import med.voll.api.controller.Medico;

@Getter
@Setter
@EqualsAndHashCode

public class DadosListagemMedicos {
    private Long id;
    private String nome;
    private String email;
    private String crm;
    private Especialidade especialidade;

    public DadosListagemMedicos(Long id,String nome, String email, String crm, Especialidade especialidade) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.crm = crm;
        this.especialidade = especialidade;
    }

    public DadosListagemMedicos(Medico dados){
        this.id = dados.getId();
        this.nome = dados.getNome();
        this.email = dados.getEmail();
        this.crm = dados.getCrm();
        this.especialidade = dados.getEspecialidade();
    }
}
