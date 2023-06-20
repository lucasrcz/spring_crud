package med.voll.api.controller;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;
import med.voll.api.medico.CadastroMedico;
import med.voll.api.medico.DadosAtualizacaoMedico;
import med.voll.api.medico.Especialidade;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String crm;
    private String telefone;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    @Embedded
    private Endereco endereco;
    private Boolean ativo ;

    public Medico(CadastroMedico dados) {
        this.ativo = true;
        this.nome = dados.getNome();
        this.email = dados.getEmail();
        this.crm = dados.getCrm();
        this.especialidade = dados.getEspecialidade();
        this.endereco = new Endereco(dados.getEndereco());
        this.telefone = dados.getTelefone();
    }

    public void AtualizarInformacoes(@Valid DadosAtualizacaoMedico dados) {
        if(dados.getNome() != null){
            this.nome = dados.getNome();
        }
        if(dados.getTelefone() != null){
            this.telefone = dados.getTelefone();
        }
        if(dados.getEmail() != null){
            this.email = dados.getEmail();
        }
        if(dados.getEndereco() != null){
            this.endereco.AtualizarInformacoes(dados.getEndereco());
        }
    }

    public void desativar() {
        this.ativo = false;
    }
}
