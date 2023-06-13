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
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((crm == null) ? 0 : crm.hashCode());
        result = prime * result + ((especialidade == null) ? 0 : especialidade.hashCode());
        result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CadastroMedico other = (CadastroMedico) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (crm == null) {
            if (other.crm != null)
                return false;
        } else if (!crm.equals(other.crm))
            return false;
        if (especialidade != other.especialidade)
            return false;
        if (endereco == null) {
            if (other.endereco != null)
                return false;
        } else if (!endereco.equals(other.endereco))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "CadastroMedico [nome=" + nome + ", email=" + email + ", crm=" + crm + ", especialidade=" + especialidade
                + ", endereco=" + endereco + "]";
    }


}
