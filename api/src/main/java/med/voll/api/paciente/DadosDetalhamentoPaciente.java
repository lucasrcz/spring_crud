package med.voll.api.paciente;


import lombok.Getter;
import lombok.Setter;
import med.voll.api.controller.Paciente;
import med.voll.api.endereco.Endereco;

@Getter
@Setter
public class DadosDetalhamentoPaciente {

    private String nome;

    private String CPF;


    private String email;

    private String telefone;

    private Endereco endereco;

    public DadosDetalhamentoPaciente(Paciente paciente){
        this.nome = paciente.getNome();
        this.CPF = paciente.getCPF();
        this.email = paciente.getEmail();
        this.telefone = paciente.getTelefone();
        this.endereco = paciente.getEndereco();
    }
}
