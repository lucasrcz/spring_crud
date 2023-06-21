package med.voll.api.controller;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;
import med.voll.api.medico.DadosAtualizacaoMedico;
import med.voll.api.paciente.CadastroPaciente;
import med.voll.api.paciente.DadosAtualizacaoPaciente;

@Table(name = "pacientes")
@Entity(name = "Paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {
    @Id @GeneratedValue
    private Long id ;
    private String nome;
    private String CPF;
    private String email;
    private String telefone;
    @Embedded
    private Endereco endereco;

    public Paciente(CadastroPaciente dados) {
        this.nome = dados.getNome();
        this.CPF = dados.getCPF();
        this.email = dados.getEmail();
        this.telefone = dados.getTelefone();
        this.endereco = new Endereco(dados.getEndereco());
    }

    public void AtualizarInformacoes(DadosAtualizacaoPaciente dados) {
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
}
