package med.voll.api.controller;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;
import med.voll.api.paciente.CadastroPaciente;

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
}
