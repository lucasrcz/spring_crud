package med.voll.api.medico;

import med.voll.api.endereco.DadosEndereco;

public class CadastroMedico {
    private String nome ;
    private String email ;
    private String crm ;
    private Especialidade especialidade ;
    private DadosEndereco endereco;
    
    CadastroMedico(String nome, String email ,String crm, Especialidade especialidade , DadosEndereco endereco ){
        this.nome = nome;
        this.email = email;
        this.crm = crm ;
        this.especialidade = especialidade;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCrm() {
        return crm;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public DadosEndereco getEndereco() {
        return endereco;
    }

    @Override
    public String toString() {
        return "CadastroMedico [nome=" + nome + ", email=" + email + ", crm=" + crm + ", especialidade=" + especialidade
                + ", endereco=" + endereco + "]";
    }


}
