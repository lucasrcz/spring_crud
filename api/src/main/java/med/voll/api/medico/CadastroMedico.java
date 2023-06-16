package med.voll.api.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.endereco.CadastroEndereco;

public class CadastroMedico {
    @NotBlank
     String nome ;
    @NotBlank
    @Email
     String email ;
    @NotBlank
     String telefone;
    @NotBlank
    @Pattern(regexp = "\\d{4,6}")
     String crm ;
    @NotNull
     Especialidade especialidade ;
    @NotNull @Valid
     CadastroEndereco endereco;
    
    CadastroMedico(String nome, String email ,String crm, Especialidade especialidade , String telefone,CadastroEndereco endereco ){
        this.nome = nome;
        this.email = email;
        this.crm = crm ;
        this.especialidade = especialidade;
        this.endereco = endereco;
        this.telefone = telefone;
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

    public String getTelefone(){return telefone;}
    public CadastroEndereco getEndereco() {
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
