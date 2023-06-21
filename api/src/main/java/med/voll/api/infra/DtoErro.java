package med.voll.api.infra;

import org.springframework.validation.FieldError;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoErro {


    private String campo;
    private String mensagem;



    public  DtoErro(FieldError erro){
        this.campo =  erro.getField();
        this.mensagem = erro.getDefaultMessage();
    }
}
