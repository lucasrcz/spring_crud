package med.voll.api.infra;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class TratadorDeErros {

    private DtoErro DtoErro ;


    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarErro404(){
        return ResponseEntity.notFound().build();
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity trataErro400(MethodArgumentNotValidException ex){
        List<FieldError> erros = ex.getFieldErrors(); //Esse método retorna um objeto complexo de error pro body sendo assim é necessário devolver um DTO mais simplificado ao cliente
        return ResponseEntity.badRequest().body(erros.stream().map(DtoErro::new).toList()); //Para isso foi criado um DTO que irá pegar o nome do campo e branco e a menssagem de erro
        //Dto criado está no DtoErro.java
    }


}

