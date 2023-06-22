package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.usuario.DadosAutenticacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados){

        //Por questões de segurança o Spring não irá manipular o DTO de usuario diretamente
        //Ele irá passar para uma classe própria do Spring que irá funcionar como um DTO
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(dados.getLogin(), dados.getSenha());
        //Esse DTO do Spring irá ser recebido pelo manager que irá gerar um objeto Authentication
        Authentication authentication = manager.authenticate(token);

        return ResponseEntity.ok().build();
    }
}
